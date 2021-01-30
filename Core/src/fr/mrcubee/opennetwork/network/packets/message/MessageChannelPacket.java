package fr.mrcubee.opennetwork.network.packets.message;

import fr.mrcubee.opennetwork.network.packets.PacketByteUtils;
import io.netty.buffer.ByteBuf;

import java.io.IOException;

public class MessageChannelPacket extends MessagePacket {

    private String channel;

    protected MessageChannelPacket(String channel, byte[] data) {
        super(data);
        this.channel = channel;
    }

    @Override
    public void decode(ByteBuf byteBuf) throws IOException {
        this.channel = PacketByteUtils.decodeString(byteBuf);
        super.decode(byteBuf);
    }

    @Override
    public void encode(ByteBuf byteBuf) throws IOException {
        PacketByteUtils.encode(byteBuf, this.channel);
        super.encode(byteBuf);
    }

    public String getChannel() {
        return this.channel;
    }
}
