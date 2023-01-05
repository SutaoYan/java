package com.sutao.newio.socket;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.concurrent.CountDownLatch;

public class Client {

    public static void main(String[] args) throws InterruptedException {
        Integer clientNumber = 3;
        CountDownLatch countDownLatch = new CountDownLatch(clientNumber);

        for (int index = 0; index < clientNumber; index++, countDownLatch.countDown()) {
            final int clientIndex = index;
            new Thread(() -> {
                sendMessage(countDownLatch, clientIndex);
            }).start();
        }

        synchronized (Client.class) {
            Client.class.wait();
        }
    }

    private static void sendMessage(CountDownLatch countDownLatch, Integer clientIndex) {

        try (Socket socket = new Socket("localhost", 9999);
             OutputStream clientRequest = socket.getOutputStream();
             InputStream clientResponse = socket.getInputStream()
        ) {

            countDownLatch.await();

            clientRequest.write(("this is request from " + clientIndex).getBytes());
            clientRequest.flush();

            System.out.println("request finished for " + clientIndex + ", waiting for server response "  + System.currentTimeMillis());

            int maxLen = 1024;
            byte[] contextBytes = new byte[maxLen];
            int realLen = 0;
            StringBuilder sb = new StringBuilder();
            while ((realLen = clientResponse.read(contextBytes, 0, maxLen)) != -1) {
                sb.append(new String(contextBytes, 0, realLen));
            }
            System.out.println("receive message from server " + sb.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
