package com.suman.java.starter;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Sample {
  public static String greet(String user) {
    return "Hello %s".formatted(user);
  }
}
