package net.ccbluex.liquidbounce.features.module.modules.hyt;

import net.ccbluex.liquidbounce.LiquidBounce
import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityLivingBase
import net.ccbluex.liquidbounce.event.AttackEvent
import net.ccbluex.liquidbounce.event.EventTarget
import net.ccbluex.liquidbounce.event.UpdateEvent
import net.ccbluex.liquidbounce.features.module.Module
import net.ccbluex.liquidbounce.features.module.ModuleCategory
import net.ccbluex.liquidbounce.features.module.ModuleInfo
import net.ccbluex.liquidbounce.value.BoolValue
import net.ccbluex.liquidbounce.value.TextValue
import net.minecraft.entity.EntityLivingBase

@ModuleInfo(name = "HytAutoL", description = "AutoL",chinesename = "花雨庭自动侮辱", category = ModuleCategory.VULGAR)
class AutoL : Module() {
    private val L = BoolValue ("L", true)
    private val AutoLmsg = TextValue("AutoLmsg", "@[瑞雪]")

    // Target
    var target: IEntityLivingBase? = null
    var kill = 0
    private fun runAttack() {
        target ?: return
        target = null
    }

    @EventTarget
    fun onAttack(event: AttackEvent) {
        target = event.targetEntity as IEntityLivingBase?
    }

    @EventTarget
    fun onUpdate(event: UpdateEvent) {

        if (target!!.isDead) {
            kill+=1
            if (L.get()) {
                mc.thePlayer!!.sendChatMessage(AutoLmsg.get() + "我已经击杀了" + kill + "人 ")
            }
            target = null
        }
    }
    override val tag: String?
        get() = "击杀 $kill"
}
