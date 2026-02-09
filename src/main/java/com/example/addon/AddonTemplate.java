package com.example.addon;

import com.example.addon.modules.CFPredictor;
import meteordevelopment.meteorclient.addons.MeteorAddon;
import meteordevelopment.meteorclient.systems.modules.Modules;

public class AddonTemplate extends MeteorAddon {
    @Override
    public void onInitialize() {
        // Registrujemo tvoj novi CF modul
        Modules.get().add(new CFPredictor());
    }

    @Override
    public String getPackage() {
        return "com.example.addon";
    }
}
