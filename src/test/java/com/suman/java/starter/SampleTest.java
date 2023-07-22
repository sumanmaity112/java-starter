package com.suman.java.starter;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SampleTest {
  @Test
  void shouldGreetUser() {
    assertThat(Sample.greet("John")).isEqualTo("Hello John");
  }
}
