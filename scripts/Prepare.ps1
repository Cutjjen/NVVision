param([string]$Target='all')
$ErrorActionPreference='Stop'
$root=(Resolve-Path "$PSScriptRoot/..").Path
$versions=@(Get-Content "$root/config/versions.json" -Raw|ConvertFrom-Json)
if($Target -ne 'all' -and $Target -notin $versions.key){throw "Alvo desconhecido: $Target"}
New-Item "$root/build/generated" -ItemType Directory -Force|Out-Null
Copy-Item "$root/config/versions.json" "$root/build/generated/variants.json" -Force
foreach($entry in (Get-Content "$root/config/sources.json" -Raw|ConvertFrom-Json)){
 if($Target -ne 'all' -and $entry.target -ne $Target){continue}
 $source=[IO.Path]::GetFullPath("$root/$($entry.source)")
 $destination=[IO.Path]::GetFullPath("$root/build/generated/$($entry.target)-$($entry.kind)/src/$($entry.path)")
 $prefix=$root+[IO.Path]::DirectorySeparatorChar
 if(!$source.StartsWith($prefix,[StringComparison]::OrdinalIgnoreCase) -or !$destination.StartsWith($prefix,[StringComparison]::OrdinalIgnoreCase)){throw 'Caminho fora do repositório'}
 New-Item (Split-Path $destination) -ItemType Directory -Force|Out-Null
 Copy-Item -LiteralPath $source -Destination $destination -Force
 $classpath="$root/.local/$($entry.target)-$($entry.kind).classpath.txt"
 if(Test-Path $classpath){Copy-Item $classpath "$root/build/generated/$($entry.target)-$($entry.kind)/classpath.txt" -Force}
}
Write-Output "Fontes preparadas: $Target"
