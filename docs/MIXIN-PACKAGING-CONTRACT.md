# Mixin packaging contract

Every MixinConfigs manifest entry must identify a valid JSON resource inside the same archive. Event-only Forge addons must not declare a Mixin configuration.

The manual legacy package adapter now discovers real *.mixins.json resources instead of assuming the addon contains nvvisionbridge.mixins.json. The Gradle Jar task validates every declared resource and parses the JSON. tools/check_mixin_resources.py additionally verifies referenced mixin class entries.

Forge 1.19.2 0.8.18 fixes the previous event-only addon manifest. The original failure was found in stdout-logs.txt; latest.log stopped before recording the exception. The old archive fails the resource check, while the new pair passes. Independent official-to-SRG GUI linkage validation passed. Game startup and world verification remain pending.
