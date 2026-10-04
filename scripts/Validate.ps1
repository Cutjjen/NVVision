$ErrorActionPreference='Stop'
Add-Type -AssemblyName System.Web.Extensions
$root=(Resolve-Path "$PSScriptRoot/..").Path
$rootPath=[IO.Path]::GetFullPath($root)
$js=New-Object System.Web.Script.Serialization.JavaScriptSerializer
$versions=@($js.Deserialize((Get-Content "$root/config/versions.json" -Raw), [object]))
$versionKeys=[System.Collections.Generic.HashSet[string]]::new([string[]]($versions | ForEach-Object { $_.key }))
$entries=@($js.Deserialize((Get-Content "$root/config/sources.json" -Raw), [object]))
$seen=@{}
foreach($entry in $entries){
 $targetName=[string]$entry.target
 if(-not $versionKeys.Contains($targetName)){throw "Alvo desconhecido: $targetName"}
 $key="$targetName|$($entry.kind)|$($entry.path)"
 if($seen.ContainsKey($key)){throw "Fonte duplicada: $key"};$seen[$key]=$true
 $file=[IO.Path]::GetFullPath((Join-Path $root $entry.source))
 if(!$file.StartsWith($rootPath+[IO.Path]::DirectorySeparatorChar,[StringComparison]::OrdinalIgnoreCase)){throw "Fonte fora do repositório: $($entry.source)"}
 if((Get-FileHash -LiteralPath $file).Hash.ToLowerInvariant() -ne $entry.sha256){throw "Hash alterado: $($entry.source). Atualize o registro após revisão."}
}
foreach($v in $versions){foreach($kind in @('mod','addon')){
 $meta=$entries|Where-Object {$_.target -eq $v.key -and $_.kind -eq $kind -and $_.path -match 'fabric.mod.json$|META-INF/(neoforge.mods|mods).toml$'}|Select-Object -First 1
 if(!$meta){throw "Metadados ausentes: $($v.key) $kind"}
 $metaFile=[IO.Path]::GetFullPath((Join-Path $root $meta.source))
 $text=Get-Content -LiteralPath $metaFile -Raw
 $version=if($kind -eq 'mod'){$v.mv}else{$v.av}
 if(!$text.Contains('Cutjjen') -or !$text.Contains($version)){throw "Autoria/versão inválida: $($v.key) $kind"}
}}
Write-Output "PASS: $($entries.Count) referências de fontes; $($versions.Count) alvos; autoria Cutjjen e metadados conferidos."
