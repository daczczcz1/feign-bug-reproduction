package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.*;
import feign.slf4j.Slf4jLogger;
import org.junit.jupiter.api.Test;

public class FeignBug {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void test() {
        TestClient client = Feign.builder()
                .logger(new Slf4jLogger(TestClient.class))
                .logLevel(Logger.Level.FULL)
                .target(TestClient.class, "https://www.google.com");
        client.get("val");
        client.get("{\"string\": \"val\", \"string2\": \"this will be truncated\"}");
    }
}

interface TestClient {
    @Headers("Custom: {customHeader}")
    @RequestLine("GET /")
    String get(@Param("customHeader") String customHeader);
}