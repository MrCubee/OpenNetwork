package fr.mrcubee.opennetwork.client;

import fr.mrcubee.opennetwork.authenticator.Authenticator;
import fr.mrcubee.opennetwork.util.StringUtils;
import io.netty.util.internal.StringUtil;

public class ClientInfo {

    private final long clientId;
    private final Authenticator authenticator;
    private ClientType clientType;
    private final String name;

    protected ClientInfo(Authenticator authenticator, ClientType clientType, String name) {
        this.clientId = System.currentTimeMillis();
        this.clientType = clientType;
        this.authenticator = authenticator;
        this.name = name;
    }

    public long getClientId() {
        return this.clientId;
    }

    public Authenticator getAuthenticator() {
        return this.authenticator;
    }

    public ClientType getClientType() {
        return this.clientType;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(this.clientId);
    }

    public ClientInfo create(Authenticator authenticator, String name) {
        if (StringUtils.isNullOrWhiteSpaceOnly(name))
            return null;
        return new ClientInfo(authenticator, ClientType.UNKNOWN, name);
    }
}
