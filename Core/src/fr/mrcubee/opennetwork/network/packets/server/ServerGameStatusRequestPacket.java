package fr.mrcubee.opennetwork.network.packets.server;

import fr.mrcubee.opennetwork.util.StringUtils;

public class ServerGameStatusRequestPacket extends ServerPacket {

    protected ServerGameStatusRequestPacket(String category, String serverName) {
        super(category, serverName);
    }

    public static ServerGameStatusRequestPacket create(String category, String serverName) {
        if (StringUtils.isOneNullOrWhiteSpaceOnly(category, serverName))
            return null;
        return new ServerGameStatusRequestPacket(category, serverName);
    }

}
