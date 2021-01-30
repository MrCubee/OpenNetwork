package fr.mrcubee.opennetwork.client.server;

import fr.mrcubee.opennetwork.authenticator.Authenticator;
import fr.mrcubee.opennetwork.client.ClientInfo;
import fr.mrcubee.opennetwork.client.ClientType;
import fr.mrcubee.opennetwork.util.StringUtils;

import java.net.InetAddress;

public class ServerClientInfo extends ClientInfo {

    private final ServerClientType serverClientType;
    private final InetAddress address;
    private final int port;
    private final String version;
    private final String category;
    private final int players;
    private final int minPlayers;
    private final int maxPlayers;

    protected ServerClientInfo(Authenticator authenticator, ServerClientType serverClientType, String category, String name, String version, InetAddress address, int port) {
        super(authenticator, ClientType.SERVER, name);
        this.serverClientType = serverClientType;
        this.address = address;
        this.port = port;
        this.version = version;
        this.category = category;
        this.players = 0;
        this.minPlayers = 0;
        this.maxPlayers = -1;
    }

    public ServerClientType getServerClientType() {
        return this.serverClientType;
    }

    public InetAddress getAddress() {
        return this.address;
    }

    public int getPort() {
        return this.port;
    }

    public String getVersion() {
        return this.version;
    }

    public String getCategory() {
        return this.category;
    }

    public int getPlayers() {
        return this.players;
    }

    public int getMinPlayers() {
        return this.minPlayers;
    }

    public int getMaxPlayers() {
        return this.maxPlayers;
    }

    public ServerClientInfo create(Authenticator authenticator, ServerClientType serverClientType, String category, String name, String version, InetAddress address, int port) {
        if (serverClientType == null|| StringUtils.isNullOrWhiteSpaceOnly(name) || StringUtils.isNullOrWhiteSpaceOnly(version)
        || address == null || port < 0 || port > 65535)
            return null;
        return new ServerClientInfo(authenticator, serverClientType, StringUtils.isNullOrWhiteSpaceOnly(category) ? null : category, name, version, address, port);
    }
}
