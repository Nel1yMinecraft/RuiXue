/*
 * LiquidBounce Base
 * God SkidBounce
 * Conding
 */
package net.ccbluex.liquidbounce.injection.forge.mixins.network;

import io.netty.channel.ChannelHandlerContext;
import net.ccbluex.liquidbounce.LiquidBounce;
import net.ccbluex.liquidbounce.event.PacketEvent;
import net.ccbluex.liquidbounce.injection.backend.PacketImplKt;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(NetworkManager.class)
public class MixinNetworkManager {

    @Inject(method = "channelRead0", at = @At("HEAD"), cancellable = true)
    private void read(ChannelHandlerContext context, Packet<?> packet, CallbackInfo callback) {
        final PacketEvent event = new PacketEvent(PacketImplKt.wrap(packet));
        LiquidBounce.eventManager.callEvent(event);

        if (event.isCancelled())
            callback.cancel();
    }

    @Inject(method = "sendPacket(Lnet/minecraft/network/Packet;)V", at = @At("HEAD"), cancellable = true)
    private void send(Packet<?> packet, CallbackInfo callback) {
        final PacketEvent event = new PacketEvent(PacketImplKt.wrap(packet));
        LiquidBounce.eventManager.callEvent(event);

        if (event.isCancelled())
            callback.cancel();
    }
}