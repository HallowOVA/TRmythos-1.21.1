package com.github.hallowOVA.mythos.registry;

import com.github.hallowOVA.mythos.entity.BlackHoleEntity;
import com.github.hallowOVA.mythos.entity.BoreasBarrier;
import com.github.hallowOVA.mythos.entity.IntrovertBarrier;
import com.github.hallowOVA.mythos.entity.ThunderStorm;
import com.github.hallowOVA.mythos.entity.boss.DendrrahEntity;
import com.github.hallowOVA.mythos.entity.projectile.DragonFireBreathProjectile;
import com.github.hallowOVA.mythos.entity.projectile.StarFallProjectile;
import com.github.hallowOVA.mythos.entity.projectile.VajraBreathProjectile;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class MythosEntityTypes {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(Registries.ENTITY_TYPE, "trmythos");

    public static final DeferredHolder<EntityType<?>, EntityType<DragonFireBreathProjectile>> DRAGONFIRE =
            ENTITY_TYPES.register("dragonfire",
                    () -> EntityType.Builder.of(DragonFireBreathProjectile::new, MobCategory.MISC)
                            .sized(1.0F, 1.0F).clientTrackingRange(64)
                            .build("dragonfire"));

    public static final DeferredHolder<EntityType<?>, EntityType<VajraBreathProjectile>> VAJRA_BREATH =
            ENTITY_TYPES.register("vajra_breath",
                    () -> EntityType.Builder.of(VajraBreathProjectile::new, MobCategory.MISC)
                            .sized(1.0f, 1.0f).clientTrackingRange(64)
                            .build("vajra_breath"));

    public static final DeferredHolder<EntityType<?>, EntityType<StarFallProjectile>> STARFALL =
            ENTITY_TYPES.register("starfall",
                    () -> EntityType.Builder.of(StarFallProjectile::new, MobCategory.MISC)
                            .sized(1.0f, 1.0f).clientTrackingRange(64)
                            .build("starfall"));

    public static final DeferredHolder<EntityType<?>, EntityType<ThunderStorm>> THUNDER_STORM =
            ENTITY_TYPES.register("thunder_storm",
                    () -> EntityType.Builder.of(ThunderStorm::new, MobCategory.MISC)
                            .sized(0.1f, 0.1f).clientTrackingRange(64).updateInterval(Integer.MAX_VALUE)
                            .build("thunder_storm"));

    public static final DeferredHolder<EntityType<?>, EntityType<IntrovertBarrier>> INTROVERT_BARRIER =
            ENTITY_TYPES.register("introvert_barrier",
                    () -> EntityType.Builder.of(IntrovertBarrier::new, MobCategory.MISC)
                            .sized(1.0f, 1.0f).clientTrackingRange(64)
                            .build("introvert_barrier"));

    public static final DeferredHolder<EntityType<?>, EntityType<BoreasBarrier>> BOREAS_BARRIER =
            ENTITY_TYPES.register("boreas_barrier",
                    () -> EntityType.Builder.of(BoreasBarrier::new, MobCategory.MISC)
                            .sized(1.0f, 1.0f).clientTrackingRange(64)
                            .build("boreas_barrier"));

    public static final DeferredHolder<EntityType<?>, EntityType<DendrrahEntity>> DENDRAHH =
            ENTITY_TYPES.register("dendrahh",
                    () -> EntityType.Builder.of(DendrrahEntity::new, MobCategory.MISC)
                            .sized(1.0f, 2.0f).clientTrackingRange(64)
                            .build("dendrahh"));

    public static final DeferredHolder<EntityType<?>, EntityType<BlackHoleEntity>> BLACK_HOLE =
            ENTITY_TYPES.register("black_hole",
                    () -> EntityType.Builder.of(BlackHoleEntity::new, MobCategory.MISC)
                            .sized(1.0f, 2.0f).clientTrackingRange(64)
                            .build("black_hole"));

    public static void register(IEventBus modEventBus) {
        ENTITY_TYPES.register(modEventBus);
    }
}