package com.example.addon.modules;

import meteordevelopment.meteorclient.events.packets.PacketEvent;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.meteorclient.systems.modules.Categories;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.network.packet.s2c.play.ScreenHandlerSlotUpdateS2CPacket;

public class CFPredictor extends Module {
    public CFPredictor() {
        super(Categories.Misc, "cf-predictor", "Predviđa ishod Coinflipa.");
    }

    @EventHandler
    private void onPacketReceive(PacketEvent.Receive event) {
        if (event.packet instanceof ScreenHandlerSlotUpdateS2CPacket p) {
            if (p.getItemStack().hasNbt()) {
                String nbt = p.getItemStack().getNbt().toString().toLowerCase();
                String nick = mc.getSession().getUsername().toLowerCase();
                
                if (nbt.contains("winner") || nbt.contains("pobednik")) {
                    if (nbt.contains(nick)) info("--- POBEDA ---");
                    else warning("--- GUBITAK ---");
                }
            }
        }
    }
}
