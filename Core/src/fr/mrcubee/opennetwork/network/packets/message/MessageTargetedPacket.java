package fr.mrcubee.opennetwork.network.packets.message;

import fr.mrcubee.opennetwork.client.ClientType;
import fr.mrcubee.opennetwork.network.packets.PacketByteUtils;
import fr.mrcubee.opennetwork.packet.Packet;
import io.netty.buffer.ByteBuf;

import java.io.IOException;

public class MessageTargetedPacket extends MessagePacket {

    private ClientType targetType;
    private String targetCategory;
    private String targetName;

    protected MessageTargetedPacket(ClientType targetType, String targetCategory, String targetName, byte[] data) {
        super(data);
        this.targetType = targetType;
        this.targetCategory = targetCategory;
        this.targetName = targetName;
    }

    @Override
    public void decode(ByteBuf byteBuf) throws IOException {
        this.targetType = ClientType.values()[byteBuf.readInt()];
        this.targetCategory = PacketByteUtils.decodeString(byteBuf);
        this.targetName = PacketByteUtils.decodeString(byteBuf);
        super.decode(byteBuf);
    }

    @Override
    public void encode(ByteBuf byteBuf) throws IOException {
        byteBuf.writeInt(targetType.ordinal());
        PacketByteUtils.encode(byteBuf, this.targetCategory);
        PacketByteUtils.encode(byteBuf, this.targetName);
        super.encode(byteBuf);
    }

    public ClientType getTargetType() {
        return this.targetType;
    }

    public String getTargetCategory() {
        return this.targetCategory;
    }

    public String getTargetName() {
        return this.targetName;
    }
}
