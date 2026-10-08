# Forge 1.19.2 renderer adapter

Rubidium is identified by its actual Forge mod ID `rubidium`, independently from Sodium. The 1.19.2 adapter reports Rubidium in integration status and accepts Rubidium or Embeddium in the client startup gate. Oculus remains optional; its existing `net.coderbot.iris` reflection bridge is preserved. Use the renderer required by the installed Oculus release; never install two renderer implementations together.

The missing dependency screen offers only Minecraft shutdown. Client-only metadata and IGNORE_ALL_VERSION preserve multiplayer independence for both components. No game installation, shader pack, world or user configuration is changed.

Other Minecraft targets keep their own dependency policy. Future legacy ports can bind these renderer detection and dependency adapters through the source catalog after checking loader APIs and renderer versions. This is not a universal binary compatibility guarantee.

Validation: compile both components, renderer gate cases, production Mixin and member references, archive resource contracts and existing graphics/CPU regressions. In-world Oculus validation remains a separate user test.
