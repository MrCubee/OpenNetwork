package fr.mrcubee.opennetwork.packet;

import fr.mrcubee.opennetwork.Network;
import fr.mrcubee.opennetwork.packet.handler.PacketHandler;
import fr.mrcubee.opennetwork.packet.handler.RegisteredPacketHandler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class PacketManager {

    private final Map<Integer, Class<? extends Packet>> packets;
    private final Map<Class<? extends Packet>, HashSet<RegisteredPacketHandler>> packetHandlers;

    public PacketManager() {
        this.packets = new HashMap<Integer, Class<? extends Packet>>();
        this.packetHandlers = new HashMap<Class<? extends Packet>, HashSet<RegisteredPacketHandler>>();
    }

    private void registerHandler(Object handler, Class<? extends Packet> packetClass, Method method) {
        HashSet<RegisteredPacketHandler> handlerList;

        if (handler == null || packetClass == null || method == null)
            return;
        handlerList = this.packetHandlers.get(packetClass);
        if (handlerList == null) {
            handlerList = new HashSet<RegisteredPacketHandler>();
            this.packetHandlers.put(packetClass, handlerList);
        }
        handlerList.add(new RegisteredPacketHandler(handler, method, packetClass));
    }

    public void registerHandler(Object object) {
        Method[] methods;

        if (object == null)
            return;
        methods = object.getClass().getDeclaredMethods();
        if (methods.length < 1)
            return;
        Arrays.stream(methods).filter(method -> method.getAnnotation(PacketHandler.class) != null
        && method.getParameterCount() == 1 && method.getParameterTypes()[0].isAssignableFrom(Packet.class)).forEach(method -> {
            registerHandler(object, (Class<? extends Packet>) method.getParameterTypes()[0], method);
        });
    }

    public void unRegisterPacketHandler(Class<? extends Packet> packetClass) {
        this.packetHandlers.remove(packetClass);
    }

    public void handle(Packet packet) {
        HashSet<RegisteredPacketHandler> handlerList;
        Method method;

        if (packet == null || (handlerList = this.packetHandlers.get(packet.getClass())) == null)
            return;
        for (RegisteredPacketHandler handler : handlerList) {
            method = handler.getMethod();
            method.setAccessible(true);
            try {
                method.invoke(handler.getHandler(), packet);
            } catch (IllegalAccessException | InvocationTargetException exception) {
                exception.printStackTrace();
            }
        }
    }

    public Class<? extends Packet> getPacketFromId(int id) {
        return this.packets.get(id);
    }

    public Integer getIdFromPacket(Class<? extends Packet> clazz) {
        if (clazz == null)
            return null;
        for (Map.Entry<Integer, Class<? extends Packet>> entry : this.packets.entrySet()) {
            if (clazz.equals(entry.getValue()))
                return entry.getKey();
        }
        return null;
    }

    public boolean registerPacket(int packetId, Class<? extends Packet> packetClass) {
        if (packetClass == null || getPacketFromId(packetId) != null)
            return false;
        this.packets.put(packetId, packetClass);
        return true;
    }
}
