package com.sutao.newio.socket;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(9999, 10)) {
            while (true) {
                Socket socket = serverSocket.accept();
                multiThreads(socket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void singleThread(Socket socket)  {

        try(
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        ) {
            Integer sourcePort = socket.getPort();
            int maxLen = 2048;
            byte[] contextBytes = new byte[maxLen];
            int realLen = in.read(contextBytes, 0, maxLen);
            String message = new String(contextBytes, 0, realLen);
            Thread.sleep(2000);
            System.out.println("receive message from port " + sourcePort + " with message " + message + System.currentTimeMillis());
            out.write(("server response for " + message).getBytes());
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void multiThreads(Socket socket) {
        new Thread(()->{
            singleThread(socket);
        }).start();
    }
}
