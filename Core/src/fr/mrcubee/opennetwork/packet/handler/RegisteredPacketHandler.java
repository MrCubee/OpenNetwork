package fr.mrcubee.opennetwork.packet.handler;

import fr.mrcubee.opennetwork.packet.Packet;

import java.lang.reflect.Method;

public class RegisteredPacketHandler {

    private final Object handler;
    private final Method method;
    private final Class<? extends Packet> packetClass;

    public RegisteredPacketHandler(Object handler, Method method, Class<? extends Packet> packetClass) {
        this.handler = handler;
        this.method = method;
        this.packetClass = packetClass;
    }

    public Object getHandler() {
        return this.handler;
    }

    public Method getMethod() {
        return this.method;
    }

    public Class<? extends Packet> getPacketClass() {
        return this.packetClass;
    }
}
