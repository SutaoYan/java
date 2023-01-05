package com.sutao.newio.netty;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.SocketChannel;

public class NettyClient {
    private final ByteBuffer readHeader = ByteBuffer.allocate(4).order(ByteOrder.BIG_ENDIAN);
    private final ByteBuffer writeHeader = ByteBuffer.allocate(4).order(ByteOrder.BIG_ENDIAN);
    private SocketChannel channel;

    public void sendMessage(byte[] body) throws Exception {
        channel = SocketChannel.open();
        channel.socket().setSoTimeout(60000);
        channel.connect(new InetSocketAddress("127.0.0.1", 1088));

        writeWithHeader(channel, body);

        readHeader.clear();
        read(channel, readHeader);
        int bodyLen = readHeader.getInt(0);
        ByteBuffer bodyBuf = ByteBuffer.allocate(bodyLen).order(ByteOrder.BIG_ENDIAN);
        read(channel, bodyBuf);
        System.out.println("<Client> Received response =" + new String(bodyBuf.array(), "UTF-8") + ", length:" + bodyLen);

    }

    private void writeWithHeader(SocketChannel channel, byte[] body) throws IOException {
        writeHeader.clear();
        writeHeader.putInt(body.length);
        writeHeader.flip();
        channel.write(ByteBuffer.wrap(body));
    }

    private void read(SocketChannel channel, ByteBuffer buffer) throws IOException {
        while (buffer.hasRemaining()) {
            int r = channel.read(buffer);
            if (-1 == r) {
                throw new IOException("end of stream when reading header");
            }
        }
    }

    public static void main(String[] args) {
        String body = "client send test request";
        try {
            new NettyClient().sendMessage(body.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
