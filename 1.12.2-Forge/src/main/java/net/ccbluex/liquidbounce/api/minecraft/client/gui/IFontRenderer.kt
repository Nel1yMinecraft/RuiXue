/*
 * LiquidBounce Base
 * God SkidBounce
 * Conding
 */

package net.ccbluex.liquidbounce.api.minecraft.client.gui

import net.ccbluex.liquidbounce.ui.font.GameFontRenderer

interface IFontRenderer {
    val fontHeight: Int

    fun getStringWidth(str: String): Int
    fun drawString(str: String, x: Int, y: Int, color: Int): Int
    fun drawString(str: String, x: Float, y: Float, color: Int, shadow: Boolean): Int
    fun drawCenteredString(text: String, x: Float, y: Float, color: Int): Int
    fun drawCenteredString(text: String, x: Float, y: Float, color: Int, shadow: Boolean): Int
    fun drawStringWithShadow(text: String, x: Int, y: Int, color: Int): Int
    fun isGameFontRenderer(): Boolean
    fun getGameFontRenderer(): GameFontRenderer
    fun listFormattedStringToWidth(message: String, i: Int): List<String>
    fun drawString(str: String, x: Float, y: Float, color: Int): Int
    fun drawString(name: String, d: Double, d1: Double, i: Int) {
    }
}