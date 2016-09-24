package com.sutao.newio;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathDemos {
  public static void main(String[] args) {
    // Using Paths.get(...) to create a Path
    Path dictionary = Paths.get("C:/", "Users", "test", "AppData", "Local", "Temp");
    System.out.println(dictionary);

    Path home = Paths.get("C:/Users/test");
    System.out.println(home);

    // Using resolve to find nested paths
    Path docs = home.resolve("Documents");
    System.out.println(docs);

    Path downloads = docs.resolveSibling("Downloads");
    System.out.println(downloads);

    // Project directory
    Path project = Paths.get(".");
    System.out.println(project);
    System.out.println(project.toAbsolutePath());
    System.out.println("As a URI:"+ project.toUri());

    // Normalize a path
    Path p = Paths.get("c:/users/test/Documents/.IntelliJIdea14/..").normalize();
    System.out.println(p);

    System.out.println("parent: " + project.toAbsolutePath().getParent());
    System.out.println("file name: "+ project.getFileName());
    System.out.println("root: " + project.toAbsolutePath().getRoot());
    for(Path path: dictionary.toAbsolutePath()) {
      System.out.println(path);
    }

    File localDir = new File("src/main");
    System.out.println(localDir);
    System.out.println(localDir.toPath().toAbsolutePath());
    System.out.println(localDir.toPath().toAbsolutePath().normalize());

  }
}
