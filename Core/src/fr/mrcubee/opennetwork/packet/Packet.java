package fr.mrcubee.opennetwork.packet;

import io.netty.buffer.ByteBuf;

import java.io.IOException;

public interface Packet {

    void decode(ByteBuf byteBuf) throws IOException;
    void encode(ByteBuf byteBuf) throws IOException;

}
