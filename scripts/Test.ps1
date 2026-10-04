param([string]$Target='all')
$ErrorActionPreference='Stop'
$root=(Resolve-Path "$PSScriptRoot/..").Path
& "$PSScriptRoot/Validate.ps1"
& "$PSScriptRoot/Prepare.ps1" -Target $Target
$toolchain=Get-Content "$root/.local/toolchain.json" -Raw|ConvertFrom-Json
if(!(Test-Path "$root/build/compiler/CompileSources.class")){throw 'Execute scripts/Build.ps1 para preparar o compilador.'}
foreach($v in (Get-Content "$root/config/versions.json" -Raw|ConvertFrom-Json)){
 if($Target -ne 'all' -and $v.key -ne $Target){continue}
 $compiler=if($v.release -eq 17){$toolchain.java17}else{$toolchain.java25}
 $runtime=switch($v.release){17 {$toolchain.java17} 21 {$toolchain.java21} default {$toolchain.java25}}
 $natives=[IO.Path]::GetFullPath($toolchain."natives$($v.release)",$root)
 foreach($kind in @('mod','addon')){
  $dir="$root/build/generated/$($v.key)-$kind"
  $sources=@((Get-ChildItem "$dir/src/main/java" -Recurse -Filter '*.java').FullName)+@((Get-ChildItem "$dir/src/test/java" -Recurse -Filter '*.java').FullName)
  & $compiler "-Dcompile.release=$($v.release)" -cp "$root/build/compiler" CompileSources "@$dir/classpath.txt" "$dir/tests" @sources *> "$dir/test-compile.log"
  if($LASTEXITCODE -ne 0){throw "Falha ao compilar testes: $($v.key) $kind"}
  $checks=if($kind -eq 'mod'){@('nvvisionboost.NVVisionBoostMenuLayoutTest','nvvisionboost.NVVisionBoostOptionsPlacementTest','nvvisionboost.NVVisionBoostIrisBridgeTest','nvvisionboost.NVVisionBoostOpenGLSmokeTest','nvvisionboost.NVVisionBoostLanguageTest')}else{@('nvvisionboost.vulkanbridge.BridgeRegressionTest','nvvisionboost.vulkanbridge.CpuOptionLeaseTest','nvvisionboost.vulkanbridge.CpuConfigurationTest')}
  $cp=(Get-Content "$dir/classpath.txt" -Raw).Trim()
  foreach($check in $checks){
   if(!(Test-Path "$dir/tests/$($check.Replace('.','/')).class")){continue}
   $arguments=@('--enable-native-access=ALL-UNNAMED',"-Dorg.lwjgl.librarypath=$natives",'-cp',"$dir/tests;$dir/src/main/resources;$cp",$check)
   if($check.EndsWith('BridgeRegressionTest')){$arguments+="$dir/regression"}
   if($check.EndsWith('CpuConfigurationTest')){$arguments+="$dir/cpu-config-test"}
   [IO.File]::WriteAllLines("$dir/test.args",($arguments|ForEach-Object {'"'+$_.Replace('\','/')+'"'}))
   & $runtime "@$dir/test.args" *> "$dir/$check.log"
   if($LASTEXITCODE -ne 0){throw "Teste falhou: $($v.key) $check"}
   Write-Output "$($v.key) $kind $((Get-Content "$dir/$check.log" -Tail 1))"
  }
 }
}
