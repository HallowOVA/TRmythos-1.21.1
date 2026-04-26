package com.github.hallowova.mythos.ability.mythos.skill.unique;

import io.github.manasmods.manascore.skill.api.ManasSkill;
import io.github.manasmods.manascore.skill.api.ManasSkillInstance;
import io.github.manasmods.tensura.ability.skill.Skill;
import io.github.manasmods.tensura.registry.attribute.TensuraAttributes;
import io.github.manasmods.tensura.registry.effect.TensuraMobEffects;
import io.github.manasmods.tensura.registry.sound.TensuraSoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.phys.AABB;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.protocol.game.ClientboundPlayerInfoRemovePacket;
import net.minecraft.network.protocol.game.ClientboundPlayerInfoUpdatePacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.players.PlayerList;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import com.mojang.authlib.GameProfile;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

import java.util.List;

public class TricksterSkill extends Skill {
    public TricksterSkill() {
        super(SkillType.UNIQUE);
    }

    private LivingEntity mimickedEntity;
    private String mimickedName;

    private static final ResourceLocation TRICKSTER =
            ResourceLocation.fromNamespaceAndPath("mythos", "trickster");

    @Override
    public MutableComponent getSkillDescription() {
        return Component.literal("Take hold of the target's senses, allowing you to form illusions which could be mistaken for reality... They may fear you for it now, but they'll come to realize it's all in good fun!");
    }

    @Override
    public double getAcquiringMagiculeCost(ManasSkillInstance instance) {
        return 500000;
    }

    public boolean canBeToggled(ManasSkillInstance instance, LivingEntity living) {
        return (instance.getMastery() >= 0.0D);
    }

    @Override
    public void onToggleOn(ManasSkillInstance instance, LivingEntity entity) {
        AttributeInstance sense = entity.getAttribute(TensuraAttributes.PRESENCE_SENSE);

        if (sense != null) {
            sense.addOrReplacePermanentModifier(
                    new AttributeModifier(
                            TRICKSTER,
                            4.0D,
                            AttributeModifier.Operation.ADD_VALUE
                    )
            );
        }

        if (!(entity instanceof Player))
            return;

        entity.addEffect(new MobEffectInstance(
                TensuraMobEffects.getReference(TensuraMobEffects.PRESENCE_CONCEALMENT),
                Integer.MAX_VALUE,
                2,
                false,
                false,
                false
        ));

        if (entity instanceof ServerPlayer player) {
            MinecraftServer server = player.server;
            PlayerList playerList = server.getPlayerList();

            ClientboundPlayerInfoRemovePacket removePkt =
                    new ClientboundPlayerInfoRemovePacket(List.of(player.getUUID()));

            MutableComponent mutableComponent = Component
                    .translatable("multiplayer.player.left", player.getDisplayName())
                    .withStyle(ChatFormatting.YELLOW);

            for (ServerPlayer target : playerList.getPlayers()) {
                MobEffectInstance effect =
                        target.getEffect((Holder<MobEffect>)
                                TensuraMobEffects.PRESENCE_SENSE);

                if (server.getProfilePermissions(target.getGameProfile()) < 2
                        || (effect != null && effect.getAmplifier() > 1)) {

                    target.connection.send(removePkt);
                    target.sendSystemMessage(mutableComponent);
                }
            }
        }
    }

    @Override
    public void onToggleOff(ManasSkillInstance instance, LivingEntity entity) {

        AttributeInstance sense = entity.getAttribute(TensuraAttributes.PRESENCE_SENSE);

        if (sense != null) {
            sense.removeModifier(TRICKSTER);
        }

        if (!(entity instanceof Player))
            return;

        entity.removeEffect(
                TensuraMobEffects.getReference(
                        TensuraMobEffects.PRESENCE_CONCEALMENT
                )
        );

        if (entity instanceof ServerPlayer player) {
            MinecraftServer server = player.server;
            PlayerList playerList = server.getPlayerList();

            ClientboundPlayerInfoUpdatePacket addPkt =
                    ClientboundPlayerInfoUpdatePacket
                            .createPlayerInitializing(List.of(player));

            MutableComponent mutableComponent = Component
                    .translatable("multiplayer.player.joined", player.getDisplayName())
                    .withStyle(ChatFormatting.YELLOW);

            for (ServerPlayer target : playerList.getPlayers()) {
                MobEffectInstance effect =
                        target.getEffect((Holder<MobEffect>)
                                TensuraMobEffects.PRESENCE_SENSE);

                if (server.getProfilePermissions(target.getGameProfile()) < 2
                        || (effect != null && effect.getAmplifier() > 1)) {

                    target.connection.send(addPkt);
                    target.sendSystemMessage(mutableComponent);
                }
            }
        }
    }

    public int getModes(ManasSkillInstance instance) {
        return 4;
    }

    public int nextMode(LivingEntity entity, ManasSkillInstance instance, int mode, boolean reverse) {
        if (reverse)
            return (mode == 0) ? 3 : (mode - 1);
        return (mode == 3) ? 0 : (mode + 1);
    }

    public String getModeId(ManasSkillInstance instance, int mode) {
        switch (mode) {
            case 0:

            case 1:

            case 2:

            case 3:

        }
        return

                super.getModeId(instance, mode);
    }

    @Override
    public void onPressed(ManasSkillInstance instance, LivingEntity entity, int keyNumber, int mode) {

        switch (mode) {

            case 0:

                if (entity.hasEffect(
                        TensuraMobEffects.getReference(
                                TensuraMobEffects.PRESENCE_CONCEALMENT))) {

                    entity.removeEffect(
                            TensuraMobEffects.getReference(
                                    TensuraMobEffects.PRESENCE_CONCEALMENT));

                    entity.level().playSound(
                            null,
                            entity.getX(),
                            entity.getY(),
                            entity.getZ(),
                            TensuraSoundEvents.GENERIC_UNCAST.get(),
                            SoundSource.PLAYERS,
                            1.0F,
                            1.0F
                    );

                    break;
                }

                entity.addEffect(new MobEffectInstance(
                        TensuraMobEffects.getReference(
                                TensuraMobEffects.PRESENCE_CONCEALMENT),
                        20 * 60,
                        2,
                        false,
                        false,
                        false
                ));


                for (LivingEntity target : entity.level()
                        .getEntitiesOfClass(
                                LivingEntity.class,
                                entity.getBoundingBox().inflate(10))) {

                    if (target == entity)
                        continue;

                    target.addEffect(new MobEffectInstance(
                            TensuraMobEffects.getReference(TensuraMobEffects.TRUE_BLINDNESS),
                            100,
                            0,
                            false,
                            true,
                            true
                    ));

                    target.addEffect(new MobEffectInstance(
                            TensuraMobEffects.getReference(
                                    TensuraMobEffects.HYPNOSIS),
                            100,
                            0,
                            false,
                            true,
                            true
                    ));
                }


                entity.level().playSound(
                        null,
                        entity.getX(),
                        entity.getY(),
                        entity.getZ(),
                        TensuraSoundEvents.PRESENCE_CONCEALMENT.get(),
                        SoundSource.PLAYERS,
                        1.0F,
                        1.0F
                );



                instance.addMasteryPoint(entity);

                break;
            case 1:

                LivingEntity target = null;

                for (LivingEntity nearby : entity.level().getEntitiesOfClass(
                        LivingEntity.class,
                        entity.getBoundingBox().inflate(50))) {

                    if (nearby == entity)
                        continue;

                    target = nearby;
                    break;
                }

                if (target == null)
                    return;

                double x = entity.getX();
                double y = entity.getY();
                double z = entity.getZ();

                entity.teleportTo(
                        target.getX(),
                        target.getY(),
                        target.getZ()
                );

                target.teleportTo(x, y, z);

                entity.level().playSound(
                        null,
                        entity.getX(),
                        entity.getY(),
                        entity.getZ(),
                        TensuraSoundEvents.BEAR_ATTACK.get(),
                        SoundSource.PLAYERS,
                        1.0F,
                        1.0F
                );

                instance.addMasteryPoint(entity);

                break;
            case 2:

                for (LivingEntity victim : entity.level().getEntitiesOfClass(
                        LivingEntity.class,
                        entity.getBoundingBox().inflate(25))) {

                    if (victim == entity)
                        continue;

                    victim.addEffect(new MobEffectInstance(
                            TensuraMobEffects.getReference(
                                    TensuraMobEffects.HYPNOSIS),
                            200,
                            3,
                            false,
                            true,
                            true
                    ));

                    victim.addEffect(new MobEffectInstance(
                            TensuraMobEffects.getReference(
                                    TensuraMobEffects.FEAR),
                            200,
                            8,
                            false,
                            true,
                            true
                    ));

                    victim.addEffect(new MobEffectInstance(
                            TensuraMobEffects.getReference(
                                    TensuraMobEffects.INSANITY),
                            200,
                            3,
                            false,
                            true,
                            true
                    ));
                }

                entity.level().playSound(
                        null,
                        entity.getX(),
                        entity.getY(),
                        entity.getZ(),
                        TensuraSoundEvents.TIGER_ATTACK.get(),
                        SoundSource.PLAYERS,
                        2.0F,
                        1.0F
                );

                instance.addMasteryPoint(entity);

                break;
            case 3:

                LivingEntity mimicTarget = getLookTarget(entity, 50);

                if (mimicTarget == null)
                    return;

                mimickedEntity = mimicTarget;
                mimickedName = mimicTarget.getName().getString();

                entity.setCustomName(Component.literal(mimickedName));
                entity.setCustomNameVisible(true);

                if (entity instanceof ServerPlayer player && mimicTarget instanceof Player targetPlayer) {

                    MinecraftServer server = player.server;
                    PlayerList playerList = server.getPlayerList();

                    ClientboundPlayerInfoRemovePacket removePacket =
                            new ClientboundPlayerInfoRemovePacket(
                                    List.of(player.getUUID()));

                    for (ServerPlayer viewer : playerList.getPlayers()) {
                        viewer.connection.send(removePacket);
                    }

                    player.setCustomName(Component.literal(targetPlayer.getName().getString()));
                    player.setCustomNameVisible(true);

                    ClientboundPlayerInfoUpdatePacket addPacket =
                            ClientboundPlayerInfoUpdatePacket.createPlayerInitializing(
                                    List.of(player)
                            );

                    for (ServerPlayer viewer : playerList.getPlayers()) {
                        viewer.connection.send(addPacket);
                    }
                }

                entity.level().playSound(
                        null,
                        entity.getX(),
                        entity.getY(),
                        entity.getZ(),
                        TensuraSoundEvents.GENERIC_CAST.get(),
                        SoundSource.PLAYERS,
                        1.5F,
                        0.8F
                );

                instance.addMasteryPoint(entity);

                break;
        }
    }
    private LivingEntity getLookTarget(LivingEntity entity, double range) {

        LivingEntity closest = null;
        double closestDistance = range * range;

        for (LivingEntity target : entity.level().getEntitiesOfClass(
                LivingEntity.class,
                entity.getBoundingBox().inflate(range))) {

            if (target == entity)
                continue;

            Vec3 look = entity.getLookAngle().normalize();
            Vec3 toTarget = target.position()
                    .add(0, target.getBbHeight() * 0.5D, 0)
                    .subtract(entity.getEyePosition())
                    .normalize();

            double dot = look.dot(toTarget);

            if (dot < 0.95D)
                continue;

            double dist = entity.distanceToSqr(target);

            if (dist < closestDistance) {
                closestDistance = dist;
                closest = target;
            }
        }

        return closest;
    }
}
