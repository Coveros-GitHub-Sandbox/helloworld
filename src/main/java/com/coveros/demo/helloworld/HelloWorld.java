package com.coveros.demo.helloworld;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HelloWorld {

  public static void main(final String[] args) {
    final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("h:mm:ss a 'on' MMMM d, yyyy'.'");
    final LocalDateTime now = LocalDateTime.now();
    
    AtomicInteger aInt1 = new AtomicInteger(0);
    AtomicInteger aInt2 = new AtomicInteger(0);
    
    if (aInt1.equals(aInt2)) { ... }

    System.out.println("Hello, World! The current time is " + dtf.format(now));
  }

}
