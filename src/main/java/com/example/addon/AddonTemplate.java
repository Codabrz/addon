package com.example.addon;

import meteordevelopment.meteorclient.addons.MeteorAddon;
import meteordevelopment.meteorclient.events.packets.PacketEvent;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.meteorclient.systems.modules.Modules;
import meteordevelopment.meteorclient.systems.modules.Categories;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.network.packet.s2c.play.ScreenHandlerSlotUpdateS2CPacket;

public class AddonTemplate extends MeteorAddon {
    @Override
    public void onInitialize() {
        // Registrujemo modul direktno ovde
        Modules.get().add(new Module(Categories.Misc, "cf-sniffer", "Vidi NBT podatke svakog slota.") {
            @EventHandler
            private void onPacketReceive(PacketEvent.Receive event) {
                if (event.packet instanceof ScreenHandlerSlotUpdateS2CPacket p) {
                    if (p.getItemStack().hasNbt()) {
                        String nbt = p.getItemStack().getNbt().toString();
                        // Ispisuje sve u chat - ovde trazimo tvoje ime ili "winner"
                        info("NBT: " + nbt);
                    }
                }
            }
        });
    }

    @Override
    public String getPackage() {
        return "com.example.addon";
    }
}
