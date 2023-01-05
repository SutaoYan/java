package com.sutao.newio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileCopy {

    public static void main(String[] args) {
        fileCopy("data/data.txt", "data/data_copy.txt");
    }

    public static void fileCopy(String src, String dest) {

        try (FileInputStream fin = new FileInputStream(src);
             FileOutputStream fout = new FileOutputStream(dest);
             FileChannel fcin = fin.getChannel();
             FileChannel fcout = fout.getChannel();) {

            ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
            while (true) {
                int r = fcin.read(buffer);

                if (r == -1) {
                    break;
                }

                buffer.flip();

                fcout.write(buffer);

                buffer.clear();
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
