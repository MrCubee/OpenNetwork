package fr.mrcubee.opennetwork.authenticator;

import fr.mrcubee.opennetwork.client.ClientInfo;

import java.net.InetAddress;
import java.nio.ByteBuffer;

public interface Authenticator {

    ClientInfo authentication(InetAddress address, ByteBuffer byteBuffer);
    
}
