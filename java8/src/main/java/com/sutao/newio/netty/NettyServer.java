package com.sutao.newio.netty;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.*;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.concurrent.Executors;

public class NettyServer {
    private static int HEADER_LENGTH = 4;

    public void bind(int port) {
        ServerBootstrap b = new ServerBootstrap(new NioServerSocketChannelFactory(Executors.newCachedThreadPool(),
                Executors.newCachedThreadPool()));

        b.setPipelineFactory(new ChannelPipelineFactory() {
            @Override
            public ChannelPipeline getPipeline() throws Exception {
                ChannelPipeline pipelines = Channels.pipeline();
                pipelines.addLast(MessageHandler.class.getName(), new MessageHandler());
                return pipelines;
            }
        });

        b.bind(new InetSocketAddress(port));
    }

    static class MessageHandler extends SimpleChannelHandler {
        public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
            ChannelBuffer buffer = (ChannelBuffer) e.getMessage();
            String message = new String(buffer.readBytes(buffer.readableBytes()).array(), "UTF-8");
            System.out.println("<Server> receive content=" + message);

            byte[] body = "server received".getBytes();
            byte[] header = ByteBuffer.allocate(HEADER_LENGTH).order(ByteOrder.BIG_ENDIAN).putInt(body.length).array();
            Channels.write(ctx.getChannel(), ChannelBuffers.wrappedBuffer(header, body));
            System.out.println("<Server> sent out time=" + System.currentTimeMillis());
        }
    }

    public static void main(String[] args) {
        try {
            new NettyServer().bind(1088);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
