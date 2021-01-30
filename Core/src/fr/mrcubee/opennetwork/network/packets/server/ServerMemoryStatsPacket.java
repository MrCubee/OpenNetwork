package fr.mrcubee.opennetwork.network.packets.server;

import fr.mrcubee.opennetwork.util.StringUtils;
import io.netty.buffer.ByteBuf;

import java.io.IOException;

public class ServerMemoryStatsPacket extends ServerPacket {

    private int maxMemory;
    private int useMemory;

    protected ServerMemoryStatsPacket(String category, String serverName, int maxMemory, int useMemory) {
        super(category, serverName);
        this.maxMemory = maxMemory;
        this.useMemory = useMemory;
    }

    @Override
    public void decode(ByteBuf byteBuf) throws IOException {
        super.decode(byteBuf);
        this.maxMemory = byteBuf.readInt();
        this.useMemory = byteBuf.readInt();
    }

    @Override
    public void encode(ByteBuf byteBuf) throws IOException {
        super.encode(byteBuf);
        byteBuf.writeInt(this.maxMemory);
        byteBuf.writeInt(this.useMemory);
    }

    public int getMaxMemory() {
        return this.maxMemory;
    }

    public int getUseMemory() {
        return this.useMemory;
    }

    public static ServerMemoryStatsPacket create(String category, String serverName, int maxMemory, int useMemory) {
        if (maxMemory < 0 || useMemory < 0 || StringUtils.isOneNullOrWhiteSpaceOnly(category, serverName))
            return null;
        return new ServerMemoryStatsPacket(category, serverName, maxMemory, useMemory);
    }
}
