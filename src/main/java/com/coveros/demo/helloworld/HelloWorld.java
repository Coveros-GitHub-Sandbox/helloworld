package com.coveros.demo.helloworld;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HelloWorld {

  public static void main(final String[] args) {
    final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("h:mm:ss a 'on' MMMM d, yyyy'.'");
    final LocalDateTime now = LocalDateTime.now();

    System.out.println("Hello, World! The current time is " + dtf.format(now));

    StringBuffer sb = new StringBuffer();
    sb.append("Name: ");
    sb.append(name + '\n');
    sb.append("!");

    String s = sb.toString();

    String s = "";
    for (Person p : persons) {
      s += ", " + p.getName();
    }
    s = s.substring(2); // remove first comma
  }

}
