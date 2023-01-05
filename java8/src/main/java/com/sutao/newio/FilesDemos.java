package com.sutao.newio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilesDemos {
  public static void main(String[] args) throws IOException{
    // Create a directory
    Path data = Files.createDirectories(Paths.get("data"));
//    Files.createFile(Paths.get("data", "data.txt"));

    // Create a directory with intermediate directories
    Files.createDirectories(Paths.get("data","sub1", "sub2", "sub3"));

    // Add an empty file to get that directory
    if(!Files.exists(Paths.get("data","sub1", "sub2", "sub3", "myFile.txt"))) {
      Files.createFile(Paths.get("data","sub1", "sub2", "sub3", "myFile.txt"));
    }

    // Delete them all
    boolean deleted = Files.deleteIfExists(Paths.get("data","sub1", "sub2", "sub3", "myFile.txt"));
//    deleted = Files.deleteIfExists(Paths.get("data"));
    deleted = Files.deleteIfExists(Paths.get("data","sub1", "sub2", "sub3"));
    deleted = Files.deleteIfExists(Paths.get("data","sub1", "sub2"));
    deleted = Files.deleteIfExists(Paths.get("data","sub1"));

    // Access a file, read it into a collection, and print
    Path sourceDir = Paths.get("data");
    Path dataFile = sourceDir.resolve("data.txt");
    System.out.println(Files.lines(dataFile).collect(Collectors.toList()));

    // Copy the file to a new location
    Path destination = sourceDir.resolve("data_copy.txt");
    Files.copy(dataFile, destination);

    // Move the file
    Path other = sourceDir.resolve("data_moved.txt");
    Files.move(destination, other);

    // Delete the copy
    Files.deleteIfExists(other);

    // Visit all the files in the source folder
    Path javaDir = Paths.get("src", "main", "java");
    try (Stream<Path> enties = Files.walk(javaDir)){
      enties.forEach(System.out::println);
    }
  }
}
