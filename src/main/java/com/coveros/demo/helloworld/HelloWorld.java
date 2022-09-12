package com.coveros.demo.helloworld;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HelloWorld {

  public static void main(final String[] args) {
    final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("h:mm:ss a 'on' MMMM d, yyyy'.'");
    final LocalDateTime now = LocalDateTime.now();
    int i = 42;
    double d = Double.longBitsToDouble(i);
    int target = -5;
    int num = 3;
    target =- num;  // Noncompliant; target = -3
    target =+ num; // Noncompliant; target = 3
    System.out.println("Hello, World! The current time is " + dtf.format(now));
  }
  

}
