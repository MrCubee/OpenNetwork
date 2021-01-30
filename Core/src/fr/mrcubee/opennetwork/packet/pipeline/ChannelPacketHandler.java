package fr.mrcubee.opennetwork.packet.pipeline;

import fr.mrcubee.opennetwork.packet.Packet;
import fr.mrcubee.opennetwork.packet.PacketManager;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ChannelPacketHandler extends SimpleChannelInboundHandler<Packet> {

    private final PacketManager packetManager;

    private ChannelPacketHandler(PacketManager packetManager) {
        this.packetManager = packetManager;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Packet packet) throws Exception {
        this.packetManager.handle(packet);
    }

    public static ChannelPacketHandler create(PacketManager packetManager) {
        if (packetManager == null)
            return null;
        return new ChannelPacketHandler(packetManager);
    }
}
