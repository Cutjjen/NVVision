"""Verify hardware-menu wiring across maintained targets; in-world rendering is separate."""
from pathlib import Path
import json

root = Path(__file__).resolve().parents[1]
catalog = json.loads((root / "config/sources.json").read_text(encoding="utf-8-sig"))

def source(target, filename):
    entry = next(x for x in catalog if x["target"] == target and x["kind"] == "mod"
                 and x["path"].endswith("/" + filename))
    return (root / "source" / entry["source"]).read_text(encoding="utf-8")

for target in sorted({x["target"] for x in catalog}):
    if target == "forge-1122":
        menu = source(target, "LegacyMenu.java")
        assert all(term in menu for term in ["Processador", "Memória RAM", "LegacyClient.addon()", "Partículas básicas"])
        assert "if (!addon() && mc.gameSettings != null)" in source(target, "LegacyClient.java")
        print("PASS", target, "legacy hardware pages, addon/basic ownership and explicit simulation limitation")
        continue
    menu = source(target, "NVVisionBoostConfigScreen.java")
    assert "case 2 -> buildProcessor(l, r, w)" in menu, target
    assert "case 3 -> buildMemory(l, r, w)" in menu, target
    cpu = menu.split("private void buildProcessor(", 1)[1].split("private void buildMemory(", 1)[0]
    assert "if (NVVisionBoostVulkanBridge.present())" in cpu, target
    assert all('"' + key + '"' in cpu for key in ["distance", "particles", "simulation", "models", "particleRange"]), target
    assert "entityOptimization" in cpu and "reduceParticles" in cpu and "} else {" in cpu, target
    performance = source(target, "NVVisionBoostPerformanceScreen.java")
    assert "controls.removeIf(Control::basicCpu)" in performance, target
    assert performance.count("    addBasic(") == 4, target
    diag = source(target, "NVVisionBoostVulkanBridgeScreen.java")
    assert "cycleCpuControl" not in diag and "cycleCpuProfile" not in diag, target
    controller = source(target, "NVVisionBoostRenderController.java")
    assert controller.count("if (!NVVisionBoostVulkanBridge.present())") >= 6, target
    adapter = source(target, "VersionAdapter.java")
    assert all(name in adapter for name in ["openScreen(", "currentScreen()", "cameraPosition()"]), target
    assert "requestCpuTransition()" in source(target, "NVVisionBoostNativeRenderer.java"), target
    assert any(x["target"] == target and x["path"].endswith("NVVisionBoostCpuParticleMixin.java") for x in catalog), target
    assert any(x["target"] == target and x["path"].endswith("NVVisionBoostBlockEntityDistanceMixin.java") for x in catalog), target
    print("PASS", target, "hardware pages, five addon callbacks, basic fallback, ownership and version-bound hooks")
