package com.hai.minh.epservice.helpler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
@Slf4j
public class JsonHelper {

    private static JsonHelper instance;
    private final ObjectMapper objectMapper;

    public JsonHelper() {
        this.objectMapper = new ObjectMapper();
    }

    public static JsonHelper getInstance() {
        if (instance == null) {
            instance = new JsonHelper();
        }
        return instance;
    }

    public String writeValueAsString(Object o) {
        try {
            return this.objectMapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            log.error("JsonProcessingException", e);
            return null;
        }
    }

    public <T> T readValue(String jsonString, Class<T> clazz) {
        try {
            return this.objectMapper.readValue(jsonString, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public <T> List<T> parseArray(String json, Class<T> clazz) {
        try {
            return this.objectMapper.readValue(json, this.objectMapper.getTypeFactory().constructCollectionType(List.class, clazz));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}