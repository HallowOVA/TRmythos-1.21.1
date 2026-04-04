package com.github.hallowOVA.mythos.registry;

import com.github.hallowOVA.mythos.item.*;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class MythosItems {

    private static final DeferredRegister<Item> registry;
    @GenerateItemModels.SingleTextureModel
    public static final RegistryObject<Item> DEMON_CORE;
    public static final RegistryObject<Item> UNDECEMBER;
    public static final RegistryObject<Item> CATHARSIS;
    public static final RegistryObject<Item> FRAGARACH;
    public static final RegistryObject<Item> GRAM;
    public static final RegistryObject<Item> EXCALIBUR;
    public static final RegistryObject<Item> VOID_HEART;

    public MythosItems() {
    }

    public static void register(IEventBus modEventBus) {
        registry.register(modEventBus);
    }

    static {
        registry = DeferredRegister.create(NeoForgeRegistries.ITEMS, "trmythos");
        DEMON_CORE = registry.register("demon_core", () -> new Item((new Item.Properties())));
        UNDECEMBER = registry.register("undecember", undecember::new);
        CATHARSIS = registry.register("catharsis", catharsis::new);
        FRAGARACH = registry.register("fragarach", fragarach::new);
        GRAM = registry.register("gram", gram::new);
        EXCALIBUR = registry.register("excalibur", excalibur::new);
        VOID_HEART = registry.register("void_heart", voidHeart::new);
    }


}
