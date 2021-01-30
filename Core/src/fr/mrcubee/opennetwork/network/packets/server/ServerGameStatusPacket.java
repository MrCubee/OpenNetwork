package fr.mrcubee.opennetwork.network.packets.server;

import fr.mrcubee.opennetwork.util.StringUtils;
import io.netty.buffer.ByteBuf;

import java.io.IOException;

public class ServerGameStatusPacket extends ServerPacket {

    private int minPlayers;
    private int maxPlayers;
    private int players;

    protected ServerGameStatusPacket(String category, String serverName, int minPlayers, int maxPlayers, int players) {
        super(category, serverName);
        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
        this.players = players;
    }

    @Override
    public void decode(ByteBuf byteBuf) throws IOException {
        super.decode(byteBuf);
        this.minPlayers = byteBuf.readInt();
        this.maxPlayers = byteBuf.readInt();
        this.players = byteBuf.readInt();
    }

    @Override
    public void encode(ByteBuf byteBuf) throws IOException {
        super.encode(byteBuf);
        byteBuf.writeInt(minPlayers);
        byteBuf.writeInt(maxPlayers);
        byteBuf.writeInt(players);
    }

    public int getMinPlayers() {
        return this.minPlayers;
    }

    public int getMaxPlayers() {
        return this.maxPlayers;
    }

    public int getPlayers() {
        return this.players;
    }

    public static ServerGameStatusPacket create(String category, String serverName, int minPlayers, int maxMemory, int players) {
        if (minPlayers < 0 || maxMemory < -1 || players < 0 || StringUtils.isOneNullOrWhiteSpaceOnly(category, serverName))
            return null;
        return new ServerGameStatusPacket(category, serverName, minPlayers, maxMemory, players);
    }
}
