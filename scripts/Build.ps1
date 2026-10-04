param([string]$Target='all')
$ErrorActionPreference='Stop'
$workspace=(Resolve-Path "$PSScriptRoot/..").Path
& "$PSScriptRoot/Validate.ps1"
& "$PSScriptRoot/Prepare.ps1" -Target $Target
if(!(Test-Path "$workspace/.local/toolchain.json")){throw 'Configure .local/toolchain.json conforme docs/COMPILACAO.md'}
$toolchain=Get-Content "$workspace/.local/toolchain.json" -Raw|ConvertFrom-Json
$java=$toolchain.java25
$jar=Join-Path (Split-Path $java) 'jar.exe'
$javac=Join-Path (Split-Path $java) 'javac.exe'
$taskRoot="$workspace/build/generated"
$port=$toolchain.minecraft12110Mappings
$toolsClasspathPath=[IO.Path]::GetFullPath($toolchain.toolsClasspathFile,$workspace)
$toolsCp=(Get-Content $toolsClasspathPath -Raw).Trim()
New-Item "$workspace/build/compiler","$workspace/build/tools" -ItemType Directory -Force|Out-Null
& $javac --release 17 -d "$workspace/build/compiler" "$workspace/tools/java/CompileSources.java"
if($LASTEXITCODE -ne 0){throw 'Falha ao preparar compilador'}
$helpers=@((Get-ChildItem "$workspace/tools/java" -Filter '*.java'|Where-Object Name -ne 'CompileSources.java').FullName)
& $java -cp "$workspace/build/compiler" CompileSources ("@"+$toolsClasspathPath) "$workspace/build/tools" @helpers
if($LASTEXITCODE -ne 0){throw 'Falha ao preparar auxiliares; confira ASM/Gson/FART'}
function Map-Jar($tool,$parameters,$log) {
 $arguments=@('-cp',("$workspace/build/tools;"+$toolsCp),$tool)+$parameters
 [IO.File]::WriteAllLines("$log.args",($arguments|ForEach-Object {'"'+$_.Replace('\','/')+'"'}))
 & $java "@$log.args" *> $log
 if($LASTEXITCODE -ne 0){throw "$tool failed: $log"}
}
foreach($variant in Get-Content "$taskRoot/variants.json" -Raw|ConvertFrom-Json) {
 if($Target -ne 'all' -and $variant.key -ne $Target){continue}
 foreach($kind in @('mod','addon')) {
  $dir="$taskRoot/$($variant.key)-$kind"
  $sources=(Get-ChildItem "$dir/src/main/java" -Recurse -Filter '*.java' | Where-Object { !($variant.mode -eq 'forge12110' -and $_.Name -eq 'NVVisionBoostIrisDepthMixin.java') }).FullName
  $compiler=if($variant.release -eq 17){$toolchain.java17}else{$java}
  & $compiler "-Dcompile.release=$($variant.release)" -cp "$workspace/build/compiler" CompileSources "@$dir/classpath.txt" "$dir/classes" @sources *> "$dir/compile.log"
  if($LASTEXITCODE -ne 0){throw "Compilation failed: $dir"}
  $version=if($kind -eq 'mod'){$variant.mv}else{$variant.av}
  $label=if($kind -eq 'mod'){'NVVisionBoost'}else{'NVVisionAddon'}
  $artifactPath="$dir/$label-$version-MC$($variant.mc).jar"
  $manifest="Manifest-Version: 1.0`nImplementation-Vendor: Cutjjen`nImplementation-Version: $version`n"
  if($variant.loader -eq 'Forge'){$manifest+="MixinConfigs: $(if($kind -eq 'mod'){'nvvisionboost.mixins.json'}else{'nvvisionbridge.mixins.json'})`n"}
  if($variant.mode -eq 'forge1201' -and $kind -eq 'addon'){$manifest=$manifest -replace '(?m)^MixinConfigs:.*\n',''}
  [IO.File]::WriteAllText("$dir/manifest.mf",$manifest+"`n")
  & $jar --create --file "$dir/dev.jar" --manifest "$dir/manifest.mf" -C "$dir/classes" . -C "$dir/src/main/resources" .
  if($LASTEXITCODE -ne 0){throw 'Packaging failed'}
  switch($variant.mode) {
   'fabric12110' {
    $refmap=if($kind -eq 'mod'){'nvvisionboost.refmap.json'}else{'nvvisionbridge.refmap.json'}
    Map-Jar 'BuildMappings' @("$port/client-mappings.txt","$port/intermediary.tiny","$dir/named-intermediary.tsrg","$dir/dev.jar","$dir/src/main/resources/$refmap","$port/minecraft-mojmap.jar") "$dir/map.log"
    & $jar --create --file "$dir/dev.jar" --manifest "$dir/manifest.mf" -C "$dir/classes" . -C "$dir/src/main/resources" .
    Map-Jar 'MemoryRemap' @("$dir/dev.jar","$dir/intermediary.jar","$dir/named-intermediary.tsrg","$port/minecraft-mojmap.jar") "$dir/remap.log"
    Map-Jar 'RemapMixinShadows' @("$dir/intermediary.jar",$artifactPath,$refmap) "$dir/shadows.log"
   }
   'forge1201' {Map-Jar 'MemoryRemap' @("$dir/dev.jar",$artifactPath,$toolchain.forge1201Mappings,$toolchain.forge1201Minecraft) "$dir/remap.log"}
   default {Copy-Item "$dir/dev.jar" $artifactPath -Force}
  }
  Write-Output "Built $($variant.loader) $($variant.mc) $kind $version"
 }
}





