package fr.mrcubee.opennetwork.packet.pipeline;

import fr.mrcubee.opennetwork.packet.Packet;
import fr.mrcubee.opennetwork.packet.PacketManager;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import java.io.IOException;

public class PacketEncoder extends MessageToByteEncoder<Packet> {

    private final PacketManager packetManager;

    private PacketEncoder(PacketManager packetManager) {
        this.packetManager = packetManager;
    }

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Packet packet, ByteBuf byteBuf) throws Exception {
        Integer integer = packetManager.getIdFromPacket(packet.getClass());

        if (integer == null)
            throw new IOException("Can't serialize unregistered packet");
        byteBuf.writeInt(integer);
        packet.encode(byteBuf);
    }

    public static PacketEncoder create(PacketManager packetManager) {
        if (packetManager == null)
            return null;
        return new PacketEncoder(packetManager);
    }
}
