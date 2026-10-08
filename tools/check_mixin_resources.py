"""Verify Mixin resources declared by manifest, Fabric or NeoForge metadata.

This inspects archives without loading Java classes or executing mod entry points.
A declared configuration must exist, parse as JSON and name packaged Mixin classes.
"""
import json
import sys
import tomllib
import zipfile

def declared_configs(jar):
    configs = set()
    names = set(jar.namelist())
    if "META-INF/MANIFEST.MF" in names:
        text = jar.read("META-INF/MANIFEST.MF").decode("utf-8").replace("\r\n", "\n").replace("\n ", "")
        headers = dict(line.split(": ", 1) for line in text.splitlines() if ": " in line)
        configs.update(x.strip() for x in headers.get("MixinConfigs", "").split(",") if x.strip())
    if "fabric.mod.json" in names:
        for entry in json.loads(jar.read("fabric.mod.json")).get("mixins", []):
            configs.add(entry if isinstance(entry, str) else entry["config"])
    for metadata in ("META-INF/neoforge.mods.toml", "META-INF/mods.toml"):
        if metadata in names:
            data = tomllib.loads(jar.read(metadata).decode("utf-8-sig"))
            configs.update(entry["config"] for entry in data.get("mixins", []))
    return configs

checks = 0
for filename in sys.argv[1:]:
    with zipfile.ZipFile(filename) as jar:
        names = set(jar.namelist())
        for config in sorted(declared_configs(jar)):
            if config not in names:
                raise ValueError(f"{filename}: declared Mixin resource missing: {config}")
            data = json.loads(jar.read(config))
            package = data.get("package", "").replace(".", "/")
            for group in ("mixins", "client", "server"):
                for classname in data.get(group, []):
                    entry = package + "/" + classname.replace(".", "/") + ".class"
                    if entry not in names:
                        raise ValueError(f"{filename}: Mixin class missing: {entry}")
            checks += 1
print(f"PASS declared Mixin resources: {checks} configs in {len(sys.argv) - 1} archives")
