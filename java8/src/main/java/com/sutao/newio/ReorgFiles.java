package com.sutao.newio;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.stream.Stream;

public class ReorgFiles {

    public static void main(String[] args) {

        Path javaDir = Paths.get("/Users/yansutao/mydoc/photo");
        try (Stream<Path> enties = Files.walk(javaDir)) {
            enties.forEach(path -> {
                File file = path.toFile();
                if (file.isFile()) {
                    BasicFileAttributes attr = null;
                    try {
                        attr = Files.readAttributes(path, BasicFileAttributes.class);
                        FileTime fileTime = attr.lastModifiedTime();
                        LocalDateTime localDateTime = LocalDateTime.ofInstant(fileTime.toInstant(), ZoneId.of("GMT+8"));

                        System.out.println(localDateTime.getYear() + ":" + localDateTime.getMonthValue());

                        Path newDir = createDir(javaDir, "" + localDateTime.getYear(), "" + localDateTime.getMonthValue());
                        Files.copy(path, Paths.get(newDir.toAbsolutePath().toString(), path.getFileName().toString()), StandardCopyOption.REPLACE_EXISTING);

                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                }
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static Path createDir(Path root, String parent, String child) throws IOException {
        Path newCreated = Paths.get(root.toAbsolutePath().toString(), parent, child);
        if (!Files.exists(newCreated)) {
            Path dir = Files.createDirectories(newCreated);
            return dir;
        }
        return newCreated;
    }
}
