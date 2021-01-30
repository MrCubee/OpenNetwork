package fr.mrcubee.opennetwork.packet.pipeline;

import fr.mrcubee.opennetwork.packet.Packet;
import fr.mrcubee.opennetwork.packet.PacketManager;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.io.IOException;
import java.util.List;

public class PacketDecoder extends ByteToMessageDecoder {

    private final PacketManager packetManager;

    private PacketDecoder(PacketManager packetManager) {
        this.packetManager = packetManager;
    }

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        int packetId;
        Class<Packet> packetClass;
        Packet packet;

        if (byteBuf.readableBytes() < 1)
            return;
        packetId = byteBuf.readInt();
        packetClass = (Class<Packet>) this.packetManager.getPacketFromId(packetId);
        if (packetClass == null)
            throw new IOException("Bad packet id: " + packetId);
        packet = packetClass.newInstance();
        packet.decode(byteBuf);
        if (byteBuf.readableBytes() > 0)
            throw new IOException("Packet " + packetId + " (" + packetClass.getSimpleName() + ") was larger than I expected, found "
                    + byteBuf.readableBytes() + "bytes extra whilst reading packet " + packet);
        list.add(packet);
    }

    public static PacketDecoder create(PacketManager packetManager) {
        if (packetManager == null)
            return null;
        return new PacketDecoder(packetManager);
    }
}
