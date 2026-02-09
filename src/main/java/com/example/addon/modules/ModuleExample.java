package a.b.c.modules;

import meteordevelopment.meteorclient.events.packets.PacketEvent;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.meteorclient.systems.modules.Categories;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.network.packet.s2c.play.ScreenHandlerSlotUpdateS2CPacket;
import a.b.c.Addon;

public class ExampleModule extends Module {
    public ExampleModule() {
        super(Categories.Misc, "cf-predictor", "Predviđa ishod Coinflipa pre kraja animacije.");
    }

    @EventHandler
    private void onPacketReceive(PacketEvent.Receive event) {
        if (event.packet instanceof ScreenHandlerSlotUpdateS2CPacket p) {
            if (p.getItemStack().hasNbt()) {
                String nbt = p.getItemStack().getNbt().toString().toLowerCase();
                String tvojeIme = mc.getSession().getUsername().toLowerCase();
                
                if (nbt.contains("winner") || nbt.contains("pobednik")) {
                    if (nbt.contains(tvojeIme)) {
                        info("--- [ DOBITAK ] ---");
                    } else {
                        warning("--- [ GUBITAK - BRZO /CF CANCEL ] ---");
                    }
                }
            }
        }
    }
}
