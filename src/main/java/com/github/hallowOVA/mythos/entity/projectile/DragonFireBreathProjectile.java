package com.github.hallowOVA.mythos.entity.projectile;

import com.github.hallowOVA.mythos.registry.MythosMobEffects;
import com.github.hallowOVA.mythos.util.damage.MythosDamageSources;
import io.github.manasmods.tensura.ability.SkillHelper;
import io.github.manasmods.tensura.damage.TensuraDamageHelper;
import io.github.manasmods.tensura.entity.magic.breath.BreathEntity;
import io.github.manasmods.tensura.handler.EffectsHandler;
import net.minecraft.client.particle.Particle;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;

public class DragonFireBreathProjectile extends BreathEntity {
    public DragonFireBreathProjectile(EntityType<? extends DragonFireBreathProjectile> entityType, Level level) {
        super(entityType, level);
        this.setNoGravity(true);
    }

    public void tick() {
        super.tick();
    }

    protected void onHitEntity(EntityHitResult entityHitResult) {
        Entity entity = entityHitResult.getEntity();
        if (entity instanceof LivingEntity living) {
            living.addEffect(new MobEffectInstance(MythosMobEffects.DRAGONFIRE.get(), 200, 0, false, false, false));
        }

        entity.setSharedFlagOnFire(true);
        DamageSource damageSource = MythosDamageSources.DRAGONFIRE;
        Entity var5 = this.getOwner();
        if (var5 instanceof LivingEntity owner) {
            damageSource = MythosDamageSources.dragonFire(owner);
        }

        TensuraDamageHelper.hurtSplitElemental(entity, damageSource, 0.9F, this.getDamage());
    }

    public void spawnParticle() {
        Entity rotation = this.getOwner();
        if (rotation instanceof LivingEntity owner) {
            Vec3 var21 = owner.getLookAngle().normalize();
            Vec3 pos = owner.position().add(var21.scale(1.6));
            double x = pos.x;
            double y = pos.y + (double)(owner.getEyeHeight() * 0.9F);
            double z = pos.z;
            double speed = owner.getRandom().nextDouble() * 0.35 + 0.35;

            for(int i = 0; i < 20; ++i) {
                double ox = Math.random() * 0.3 - 0.15;
                double oy = Math.random() * 0.3 - 0.15;
                double oz = Math.random() * 0.3 - 0.15;
                Vec3 randomVec = (new Vec3(Math.random() - 0.5, Math.random() - 0.5, Math.random() - 0.5)).normalize();
                Vec3 result = var21.scale(3.0).add(randomVec).normalize().scale(speed);
                owner.level().addParticle(ParticleTypes.ASH, x + ox, y + oy, z + oz, result.x, result.y, result.z);
            }
        }
    }


}
