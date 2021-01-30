package fr.mrcubee.opennetwork.network.packets.server;

import fr.mrcubee.opennetwork.util.StringUtils;

public class ServerMemoryStatsRequestPacket extends ServerPacket {

    protected ServerMemoryStatsRequestPacket(String category, String serverName) {
        super(category, serverName);
    }

    public static ServerMemoryStatsRequestPacket create(String category, String serverName) {
        if (StringUtils.isOneNullOrWhiteSpaceOnly(category, serverName))
            return null;
        return new ServerMemoryStatsRequestPacket(category, serverName);
    }
}
