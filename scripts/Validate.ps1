$ErrorActionPreference='Stop'
$root=(Resolve-Path "$PSScriptRoot/..").Path
$versions=@(Get-Content "$root/config/versions.json" -Raw|ConvertFrom-Json)
$entries=@(Get-Content "$root/config/sources.json" -Raw|ConvertFrom-Json)
$seen=@{}
foreach($entry in $entries){
 if($entry.target -notin $versions.key){throw "Alvo desconhecido: $($entry.target)"}
 $key="$($entry.target)|$($entry.kind)|$($entry.path)"
 if($seen.ContainsKey($key)){throw "Fonte duplicada: $key"};$seen[$key]=$true
 $file=[IO.Path]::GetFullPath("$root/$($entry.source)")
 if(!$file.StartsWith($root+[IO.Path]::DirectorySeparatorChar,[StringComparison]::OrdinalIgnoreCase)){throw 'Fonte fora do repositório'}
 if((Get-FileHash -LiteralPath $file).Hash.ToLowerInvariant() -ne $entry.sha256){throw "Hash alterado: $($entry.source). Atualize o registro após revisão."}
}
foreach($v in $versions){foreach($kind in @('mod','addon')){
 $meta=$entries|Where-Object {$_.target -eq $v.key -and $_.kind -eq $kind -and $_.path -match 'fabric.mod.json$|META-INF/(neoforge.mods|mods).toml$'}|Select-Object -First 1
 if(!$meta){throw "Metadados ausentes: $($v.key) $kind"}
 $text=Get-Content "$root/$($meta.source)" -Raw
 $version=if($kind -eq 'mod'){$v.mv}else{$v.av}
 if(!$text.Contains('Cutjjen') -or !$text.Contains($version)){throw "Autoria/versão inválida: $($v.key) $kind"}
}}
Write-Output "PASS: $($entries.Count) referências de fontes; $($versions.Count) alvos; autoria Cutjjen e metadados conferidos."
