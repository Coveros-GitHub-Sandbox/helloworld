package com.coveros.demo.helloworld;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.*;

public class HelloWorld {

  public static void main(final String[] args) throws IOException {
    final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("h:mm:ss a 'on' MMMM d, yyyy'.'");
    final LocalDateTime now = LocalDateTime.now();

    // ProcessBuilder pb = new ProcessBuilder(
    // "C:/MZO/minikube/helloworld/target",
    // "x",
    // "demo-frontend-1.0-SNAPSHOT.jar",
    // "*.*",
    // "new");
    // pb.directory(new File("C:/MZO/minikube/helloworld/target/"));
    // pb.redirectErrorStream(true);
    // Process p = pb.start();
    // p.getInputStream().read();
    // System.out.println("Hello, World! The current time is " + dtf.format(now));
  }

}
