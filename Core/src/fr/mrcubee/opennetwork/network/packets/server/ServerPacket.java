package fr.mrcubee.opennetwork.network.packets.server;

import fr.mrcubee.opennetwork.network.packets.PacketByteUtils;
import fr.mrcubee.opennetwork.packet.Packet;
import io.netty.buffer.ByteBuf;

import java.io.IOException;

public class ServerPacket implements Packet {

    private String category;
    private String serverName;

    protected ServerPacket(String category, String serverName) {
        this.category = category;
        this.serverName = serverName;
    }

    @Override
    public void decode(ByteBuf byteBuf) throws IOException {
        this.category = PacketByteUtils.decodeString(byteBuf);
        this.serverName = PacketByteUtils.decodeString(byteBuf);
    }

    @Override
    public void encode(ByteBuf byteBuf) throws IOException {
        PacketByteUtils.encode(byteBuf, this.category);
        PacketByteUtils.encode(byteBuf, this.serverName);
    }

    public String getCategory() {
        return this.category;
    }

    public String getServerName() {
        return this.serverName;
    }
}
