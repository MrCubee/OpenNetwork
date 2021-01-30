package fr.mrcubee.opennetwork.network.packets;

import fr.mrcubee.opennetwork.network.packets.message.MessageChannelPacket;
import fr.mrcubee.opennetwork.network.packets.message.MessageTargetedPacket;
import fr.mrcubee.opennetwork.network.packets.server.ServerGameStatusPacket;
import fr.mrcubee.opennetwork.network.packets.server.ServerGameStatusRequestPacket;
import fr.mrcubee.opennetwork.network.packets.server.ServerMemoryStatsPacket;
import fr.mrcubee.opennetwork.network.packets.server.ServerMemoryStatsRequestPacket;
import fr.mrcubee.opennetwork.packet.Packet;

public enum Packets {

    MESSAGE_CHANNEL(MessageChannelPacket.class),
    MESSAGE_TARGETED(MessageTargetedPacket.class),

    SERVER_MEMORY_STATS_REQUEST(ServerMemoryStatsRequestPacket.class),
    SERVER_MEMORY_STATS(ServerMemoryStatsPacket.class),

    SERVER_GAME_STATUS_REQUEST(ServerGameStatusRequestPacket.class),
    SERVER_GAME_STATUS(ServerGameStatusPacket.class),

    PROXY_SEND_PLAYER_REQUEST(null),
    PROXY_SEND_PLAYER_REPLY(null),

    PROXY_PLAYER_RESERVE_SLOT_REQUEST(null),
    PROXY_PLAYER_RESERVE_SLOT_REPLY(null),

    PROXY_PLAYER_BAN_REQUEST(null),
    PROXY_PLAYER_BAN_REPLY(null),

    PROXY_PLAYER_ROLE_REQUEST(null),
    PROXY_PLAYER_ROLE_REPLY(null),
    PROXY_PLAYER_ROLE_UPDATE_REQUEST(null),
    PROXY_PLAYER_ROLE_UPDATE_REPLY(null),

    PROXY_STATS_REQUEST(null),
    PROXY_STATS_REPLY(null),

    SOD_CREATE_REQUEST(null),
    SOD_CREATE_REPLY(null),

    SOD_REMOVE_REQUEST(null),
    SOD_REMOVE_REPLY(null);

    private final Class<? extends Packet> packetClass;

    Packets(Class<? extends Packet> packetClass) {
        this.packetClass = packetClass;
    }

    public Class<? extends Packet> getPacketClass() {
        return this.packetClass;
    }

    public Packet getPacketInstance() {
        Class<Packet> packetClass = (Class<Packet>) getPacketClass();
        Packet result = null;

        if (packetClass == null)
            return null;
        try {
            result = packetClass.newInstance();
        } catch (InstantiationException | IllegalAccessException execption) {
            execption.printStackTrace();
        }
        return result;
    }

    public int getPacketId() {
        return ordinal();
    }
}
