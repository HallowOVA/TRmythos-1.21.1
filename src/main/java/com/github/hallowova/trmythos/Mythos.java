package com.github.hallowova.trmythos;

import com.github.hallowova.trmythos.registry.MythosRegistry;
import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(Mythos.MODID)
public final class Mythos {
    public static final String MODID = "trmythos";
    public static final Logger LOGGER = LogUtils.getLogger();

    public Mythos(IEventBus modEventBus) {
        MythosRegistry.init();
    }

}
