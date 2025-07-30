package com.returnpredictor.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfig {

  @Bean
  public ObjectMapper objectMapper() {
    ObjectMapper objectMapper = new ObjectMapper();

    // Optional: Enable pretty printing globally
    objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

    // Optional: Ignore null values globally
    objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

    // Optional: Other global Jackson configs here
    return objectMapper;
  }
}
