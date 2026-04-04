package com.github.hallowOVA.mythos.registry;

import com.github.hallowOVA.mythos.mob_effect.*;
import com.github.hallowOVA.mythos.mob_effect.debuff.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.awt.Color;

public class MythosMobEffects {

    public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(Registries.MOB_EFFECT, "trmythos");

    public static final DeferredHolder<MobEffect, MobEffect> AVALON_REGENERATION = REGISTRY.register("avalon_regeneration", () ->
            new AvalonRegenerationEffect(MobEffectCategory.BENEFICIAL, new Color(255, 166, 4).getRGB()));

    public static final DeferredHolder<MobEffect, MobEffect> APOSTLE_REGENERATION = REGISTRY.register("apostle_regeneration", () ->
            new ApostleRegenerationEffect(MobEffectCategory.BENEFICIAL, new Color(40, 2, 66).getRGB()));

    public static final DeferredHolder<MobEffect, MobEffect> DEAD_REGENERATION = REGISTRY.register("dead_apostle_regeneration", () ->
            new DeadRegenerationEffect(MobEffectCategory.BENEFICIAL, new Color(80, 2, 66).getRGB()));

    public static final DeferredHolder<MobEffect, MobEffect> RAPID_REGENERATION = REGISTRY.register("rapid_regeneration", () ->
            new RapidRegenerationEffect(MobEffectCategory.BENEFICIAL, new Color(255, 166, 4).getRGB()));

    public static final DeferredHolder<MobEffect, MobEffect> VAPORIZATION_FREEZE = REGISTRY.register("vaporization_freeze", () ->
            new VaporizationFreezeEffect(MobEffectCategory.HARMFUL, new Color(255, 144, 6).getRGB()));

    public static final DeferredHolder<MobEffect, MobEffect> BLOOD_DRAIN = REGISTRY.register("blood_drain", () ->
            new BloodDrainEffect(MobEffectCategory.HARMFUL, new Color(255, 165, 3).getRGB()));

    public static final DeferredHolder<MobEffect, MobEffect> CHILD_OF_THE_PLANE = REGISTRY.register("child_of_the_plane_effect", () ->
            new ChildOfThePlaneEffect(MobEffectCategory.BENEFICIAL, new Color(255, 165, 3).getRGB()));

    public static final DeferredHolder<MobEffect, MobEffect> DRAGONFIRE = REGISTRY.register("dragonfire", () ->
            new DragonfireEffect(MobEffectCategory.HARMFUL, new Color(255, 0, 0).getRGB()));

    public static final DeferredHolder<MobEffect, MobEffect> BLOOD_COAT = REGISTRY.register("blood_coat", () ->
            new BloodCoatEffect(MobEffectCategory.BENEFICIAL, new Color(220, 20, 60).getRGB()));

    public static final DeferredHolder<MobEffect, MobEffect> COMPLETE_REGENERATION = REGISTRY.register("complete_regeneration", () ->
            new CompleteRegenerationEffect(MobEffectCategory.BENEFICIAL, new Color(255, 0, 0).getRGB()));

    public static final DeferredHolder<MobEffect, MobEffect> ROT = REGISTRY.register("rot", () ->
            new RotEffect(MobEffectCategory.HARMFUL, new Color(255, 0, 0).getRGB()));

    public static final DeferredHolder<MobEffect, MobEffect> EXCALIBUR_REGENERATION = REGISTRY.register("excalibur_regeneration", () ->
            new ExcaliburRegeneration(MobEffectCategory.BENEFICIAL, new Color(15, 100, 100).getRGB()));

    public static final DeferredHolder<MobEffect, MobEffect> ENERGIZED_REGENERATION = REGISTRY.register("energized_regeneration", () ->
            new EnergizedRegenerationEffect(MobEffectCategory.BENEFICIAL, new Color(255, 166, 4).getRGB()));

    public static final DeferredHolder<MobEffect, MobEffect> EMPOWERMENT_REGENERATION = REGISTRY.register("empowerment_regeneration", () ->
            new EmpowermentRegenerationEffect(MobEffectCategory.BENEFICIAL, new Color(255, 166, 4).getRGB()));

    public static final DeferredHolder<MobEffect, MobEffect> LIGHTNING_COAT = REGISTRY.register("lightning_coat", () ->
            new LightningCoatEffect(MobEffectCategory.BENEFICIAL, new Color(15, 100, 125).getRGB()));

    public static final DeferredHolder<MobEffect, MobEffect> THUNDER_GOD = REGISTRY.register("thunder_god", () ->
            new ThunderGodEffect(MobEffectCategory.BENEFICIAL, new Color(15, 100, 150).getRGB()));

    public static final DeferredHolder<MobEffect, MobEffect> GOD_SLAYER = REGISTRY.register("god_slayer", () ->
            new GodSlayerEffect(MobEffectCategory.BENEFICIAL, new Color(15, 255, 100).getRGB()));

    public static final DeferredHolder<MobEffect, MobEffect> COSTLESS_REGENERATION = REGISTRY.register("costless_regeneration", () ->
            new CostlessRegenerationEffect(MobEffectCategory.BENEFICIAL, new Color(255, 0, 0).getRGB()));

    public static final DeferredHolder<MobEffect, MobEffect> ULTIMATE_VILLAIN = REGISTRY.register("ultimate_villain", () ->
            new UltimateVillainEffect(MobEffectCategory.BENEFICIAL, new Color(100, 0, 0).getRGB()));

    public static final DeferredHolder<MobEffect, MobEffect> FINAL_SEAL_DOOM = REGISTRY.register("final_seal_doom", () ->
            new FinalSealDoomEffect(MobEffectCategory.HARMFUL, new Color(100, 0, 0).getRGB()));

    public static final DeferredHolder<MobEffect, MobEffect> SPATIAL_DYSPHORIA = REGISTRY.register("spatial_dysphoria", () ->
            new SpatialDysphoriaEffect(MobEffectCategory.NEUTRAL, new Color(90, 20, 90).getRGB()));

    public static final DeferredHolder<MobEffect, MobEffect> NON_EUCLIDEAN_STEP = REGISTRY.register("non_euclidean_step", () ->
            new NonEuclideanStepEffect(MobEffectCategory.NEUTRAL, new Color(90, 20, 90).getRGB()));

    public static final DeferredHolder<MobEffect, MobEffect> BOUNDARY_ERASURE_SINK = REGISTRY.register("boundary_erasure_sink", () ->
            new BoundaryErasureSinkEffect(MobEffectCategory.NEUTRAL, new Color(90, 20, 90).getRGB()));

    public static final DeferredHolder<MobEffect, MobEffect, MobEffect> BOUNDARY_ERASURE_USER = REGISTRY.register("boundary_erasure_user", () ->
            new BoundaryErasureUserEffect(MobEffectCategory.NEUTRAL, new Color(90, 20, 90).getRGB()));

    public static final DeferredHolder<MobEffect, MobEffect> ATROPHY = REGISTRY.register("atropohy", () ->
            new AtrophyEffect(MobEffectCategory.NEUTRAL, new Color(90, 20, 90).getRGB()));

    public static final DeferredHolder<MobEffect, MobEffect> GREAT_SILENCE = REGISTRY.register("great_silence", () ->
            new GreatSilenceEffect(MobEffectCategory.NEUTRAL, new Color(90, 20, 90).getRGB()));

    public static final DeferredHolder<MobEffect, MobEffect> YELLOW_SIGN = REGISTRY.register("yellow_sign", () ->
            new YellowSignEffect(MobEffectCategory.NEUTRAL, new Color(255, 165, 15).getRGB()));

    public static final DeferredHolder<MobEffect, MobEffect> SUNSET = REGISTRY.register("sunset", () ->
            new SunriseEffect(MobEffectCategory.NEUTRAL, new Color(255, 165, 15).getRGB()));

    public static final DeferredHolder<MobEffect, MobEffect> SUNRISE = REGISTRY.register("sunrise", () ->
            new SunsetEffect(MobEffectCategory.NEUTRAL, new Color(255, 165, 15).getRGB()));

    public static final DeferredHolder<MobEffect, MobEffect> KHONSU = REGISTRY.register("khonsu", () ->
            new EyeOfTheMoonKhonsuEffect(MobEffectCategory.NEUTRAL, new Color(255, 165, 15).getRGB()));

    public static final DeferredHolder<MobEffect, MobEffect> MAMMON_FLARE = REGISTRY.register("mammon_flare", () ->
            new MammonFlareEffect(MobEffectCategory.NEUTRAL, new Color(255, 165, 15).getRGB()));

    public static final DeferredHolder<MobEffect, MobEffect> ENCHAIN_EFFECT = REGISTRY.register("enchain", () ->
            new EnchainEffect(MobEffectCategory.HARMFUL, new Color(20, 50, 105).getRGB()));

    public static final DeferredHolder<MobEffect, MobEffect> ARES_BERSERKER = REGISTRY.register("ares_berserker", () ->
            new AresBerserkerEffect(MobEffectCategory.NEUTRAL, new Color(255, 165, 15).getRGB()));

    public static final DeferredHolder<MobEffect, MobEffect> LONGEVITY_REGENERATION = REGISTRY.register("longevity_regeneration", () ->
            new LongevityRegenerationEffect(MobEffectCategory.BENEFICIAL, new Color(100, 0, 0).getRGB()));

    public static final DeferredHolder<MobEffect, MobEffect> SCHRODINGERS_LABYRINTH = REGISTRY.register("schrodingers_labyrinth", () ->
            new SchrodingersLabyrinthEffect(MobEffectCategory.NEUTRAL, new Color(100, 0, 0).getRGB()));

    public static final DeferredHolder<MobEffect, MobEffect> EVIL_OF_HUMANITY = REGISTRY.register("evil_of_humanity", EvilOfHumanityEffect::new);
    public static final DeferredHolder<MobEffect, MobEffect> PATHOGEN = REGISTRY.register("pathogen", PathogenEffect::new);
    public static final DeferredHolder<MobEffect, MobEffect> PATHOGEN_DECEPTION = REGISTRY.register("pathogen_deception", PathogenDeception::new);

    public static final DeferredHolder<MobEffect, MobEffect> FLESH = REGISTRY.register("flesh", () ->
            new RotEffect(MobEffectCategory.HARMFUL, new Color(255, 0, 0).getRGB()));

    public static void register(IEventBus modEventBus) {
        REGISTRY.register(modEventBus);
    }
}