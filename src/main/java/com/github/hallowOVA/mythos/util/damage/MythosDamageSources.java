package com.github.hallowOVA.mythos.util.damage;

import com.github.manasmods.manascore.api.skills.ManasSkill;
import com.github.manasmods.manascore.api.skills.ManasSkillInstance;
import com.github.manasmods.tensura.util.damage.TensuraDamageSource;
import com.github.manasmods.tensura.util.damage.TensuraEntityDamageSource;
import com.github.mythos.mythos.ability.confluence.skill.ConfluenceUniques;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;

public class MythosDamageSources {

    public static final String DESTROY_RECORD = "trmythos.destroy_record";
    public static String TRUTH_DAMAGE = "trmythos.truth";
    public static final DamageSource DRAGONFIRE = (new DamageSource("trmythos.dragonfire")).setIsFire().bypassEnchantments().setMagic().setNoAggro();
    public static final DamageSource ROT = (new DamageSource("trmythos.rot")).setNotTensuraMagic().bypassArmor().bypassEnchantments().setMagic();
    public static final DamageSource OVERPRESSURE_BURST_WIND = (new DamageSource("trmythos.overpressure_burst_wind")).bypassArmor();
    public static final DamageSource VAJRA_SPEAR = (new DamageSource("trmythos.vajra_spear_lightning")).bypassArmor().bypassMagic().bypassInvul();
    public static final DamageSource BLOOD = (new DamageSource("trmythos.blood")).bypassArmor().bypassMagic().bypassEnchantments();
    public static final DamageSource END_OF_EVIL = (new DamageSource("trmythos.end_of_evil")).bypassArmor().bypassMagic().bypassEnchantments();
    public static final DamageSource Horseman = (new DamageSource("trmythos.horseman")).bypassArmor().bypassMagic().bypassEnchantments().bypassInvul();


    public MythosDamageSources() {
    }

    public static DamageSource destroyRecord(Entity pSource) {
        return (new DamageSource("trmythos.destory_record", pSource)).setNoKnock().setIgnoreBarrier(1.0F).bypassArmor().bypassInvul().bypassMagic();
    }

    public static DamageSource dragonFire(Entity entity) {
        return (new DamageSource("trmythos.dragonfire", entity)).setNoKnock().bypassArmor().setIsFire().setMagic().setNoAggro();
    }

    public static DamageSource rot(Entity pSource) {
        return (new DamageSource("trmythos.rot", pSource)).setNoKnock().setNotTensuraMagic().bypassArmor().bypassEnchantments().setMagic();
    }
    public static DamageSource truthDamage(Entity pSource) {
        return (new DamageSource("trmythos.truth", pSource)).setSkill(new ManasSkillInstance((ManasSkill) ConfluenceUniques.FRAGARACH.get())).setNoKnock().setIgnoreBarrier(1.0F).bypassArmor().bypassInvul().bypassMagic();
    }
    public static DamageSource overpressureBurstWind() {
        return (new DamageSource("trmythos.overpressure_burst_wind")).bypassArmor();
    }
    public static DamageSource vajraSpear() {
        return (new DamageSource("trmythos.vajra_spear_lightning")).bypassArmor().bypassMagic().bypassInvul();
    }
    public static DamageSource BadNewsDamage =
            new DamageSource("trmythos.bad_news").bypassArmor().bypassMagic().setMagic().bypassInvul().bypassEnchantments().setExplosion();

    public static DamageSource blood() {
        return (new DamageSource("trmythos.blood")).bypassArmor().bypassMagic().bypassEnchantments();
    }
    public static DamageSource EndOfEvil() {
        return (new DamageSource("trmythos.end_of_evil")).bypassArmor().bypassMagic().bypassEnchantments().bypassInvul();
    }

    public static DamageSource GreatDecay() {
        return (new DamageSource("trmythos.great_decay")).bypassArmor().bypassArmor().bypassArmor().bypassInvul();
    }

    public static DamageSource Horseman(Entity source) {
        return new DamageSource("trmythos.horseman", source).bypassArmor().bypassMagic().bypassEnchantments().bypassInvul();
    }

}
