package com.suman.java.starter;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

@IntegrationTest
class SampleIntegrationTest {
  @Test
  void shouldGreetWorld() {
    assertThat(Sample.greet("World")).isEqualTo("Hello World");
  }
}
