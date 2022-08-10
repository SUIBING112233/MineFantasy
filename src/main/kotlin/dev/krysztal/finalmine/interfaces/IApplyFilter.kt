package dev.krysztal.finalmine.interfaces

import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Player

fun interface IApplyFilter {
    fun f(entity: LivingEntity?, player: Player?): Boolean
}