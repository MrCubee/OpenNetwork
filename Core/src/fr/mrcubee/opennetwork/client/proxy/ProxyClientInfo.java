package fr.mrcubee.opennetwork.client.proxy;

import fr.mrcubee.opennetwork.authenticator.Authenticator;
import fr.mrcubee.opennetwork.client.ClientInfo;
import fr.mrcubee.opennetwork.client.ClientType;

public class ProxyClientInfo extends ClientInfo {

    protected ProxyClientInfo(Authenticator authenticator, String name) {
        super(authenticator, ClientType.PROXY, name);
    }
}
