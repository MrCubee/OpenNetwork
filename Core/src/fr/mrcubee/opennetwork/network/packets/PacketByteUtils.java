package fr.mrcubee.opennetwork.network.packets;

import io.netty.buffer.ByteBuf;

import java.io.IOException;

public class PacketByteUtils {

    public static void encode(ByteBuf byteBuf, byte[] bytes) {
        if (byteBuf == null)
            return;
        else if (bytes == null || bytes.length < 1) {
            byteBuf.writeInt(0);
            return;
        }
        byteBuf.writeInt(bytes.length);
        byteBuf.writeBytes(bytes);
    }

    public static byte[] decodeBytes(ByteBuf byteBuf) {
        int length;
        byte[] bytes;

        if (byteBuf == null || (length = byteBuf.readInt()) < 1)
            return null;
        bytes = new byte[length];
        byteBuf.readBytes(bytes, 0, length);
        return bytes;
    }

    public static void encode(ByteBuf byteBuf, String str) throws IOException {
        encode(byteBuf, (str != null && !str.isEmpty()) ? str.getBytes() : null);
    }

    public static String decodeString(ByteBuf byteBuf) {
        byte[] bytes = decodeBytes(byteBuf);

        if (bytes == null)
            return null;
        return new String(bytes);
    }



}
