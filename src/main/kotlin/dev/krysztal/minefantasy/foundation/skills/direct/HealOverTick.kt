package dev.krysztal.minefantasy.foundation.skills.direct

import dev.krysztal.minefantasy.foundation.addPotionEffect
import dev.krysztal.minefantasy.foundation.playerFilter
import dev.krysztal.minefantasy.foundation.skills.DirectDamage
import dev.krysztal.minefantasy.foundation.skills.SkillType
import dev.krysztal.minefantasy.foundation.toTickDuration
import dev.krysztal.minefantasy.foundation.utils.ParticleUtils
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Player
import org.bukkit.potion.PotionEffectType

open class HealOverTick(
    amplifier: Int,
    
    distance: Int = 30,
    mana: Int = 400,
    heal: Int = 4,
    duration: Int = 20 * 18,
    coolDown: Double = 2.5.toTickDuration(),
    skillType: SkillType = SkillType.Magic
) : DirectDamage(
    distance = distance,
    filter = playerFilter,
    mana = mana,
    coolDown = coolDown,
    skillType = skillType,
    effect = { livingEntity: LivingEntity?, _: Player? ->
        ParticleUtils.spawnCureParticle(livingEntity)
        livingEntity!!.health = (livingEntity.health + heal).coerceAtMost(livingEntity.maxHealth)
        livingEntity.addPotionEffect(PotionEffectType.REGENERATION, duration, amplifier)
    }
)