package fr.mrcubee.opennetwork;

import fr.mrcubee.opennetwork.authenticator.Authenticator;
import fr.mrcubee.opennetwork.packet.PacketManager;

public interface Network {

    boolean addAuthenticator(Authenticator authenticator);
    boolean removeAuthenticator(Class<? extends Authenticator> authenticatorClass);
    boolean removeAuthenticator(Authenticator authenticator);
    PacketManager getPacketManager();
    void close();

}
