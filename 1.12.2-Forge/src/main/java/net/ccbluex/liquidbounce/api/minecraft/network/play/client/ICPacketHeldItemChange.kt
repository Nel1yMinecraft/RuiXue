/*
 * LiquidBounce Base
 * God SkidBounce
 * Conding
 */

package net.ccbluex.liquidbounce.api.minecraft.network.play.client

import net.ccbluex.liquidbounce.api.minecraft.network.IPacket

interface ICPacketHeldItemChange : IPacket {
    val slotId: Int
}