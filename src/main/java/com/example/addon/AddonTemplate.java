package a.b.c;

import a.b.c.modules.ExampleModule;
import meteordevelopment.meteorclient.addons.MeteorAddon;
import meteordevelopment.meteorclient.systems.modules.Modules;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Addon extends MeteorAddon {
    public static final Logger LOG = LoggerFactory.getLogger(Addon.class);

    @Override
    public void onInitialize() {
        LOG.info("Ucitavam CF Predictor Addon!");

        // Registracija tvog modula
        Modules.get().add(new ExampleModule());
    }

    @Override
    public String getPackage() {
        return "a.b.c";
    }
}
