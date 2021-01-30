package fr.mrcubee.opennetwork.network.packets.message;

import fr.mrcubee.opennetwork.network.packets.PacketByteUtils;
import fr.mrcubee.opennetwork.packet.Packet;
import io.netty.buffer.ByteBuf;

import java.io.IOException;

public class MessagePacket implements Packet {

    private byte[] data;

    protected MessagePacket(byte[] data) {
        this.data = data;
    }

    protected MessagePacket(String data) {
        this.data = data.getBytes();
    }

    @Override
    public void decode(ByteBuf byteBuf) throws IOException {
        this.data = PacketByteUtils.decodeBytes(byteBuf);
    }

    @Override
    public void encode(ByteBuf byteBuf) throws IOException {
        PacketByteUtils.encode(byteBuf, this.data);
    }

    public byte[] getData() {
        return this.data;
    }

    public String getStringData() {
        return new String(getData());
    }
}
