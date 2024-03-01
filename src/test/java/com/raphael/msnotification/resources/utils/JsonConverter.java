package com.raphael.msnotification.resources.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;

public class JsonConverter {

    public static String convertIntoJson(String UserEmail, String eventType) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("email", UserEmail);
        map.put("event", eventType);
        map.put("date", LocalDateTime.now().format(DateTimeFormatter.ISO_DATE));

        return mapper.writeValueAsString(map);
    }
}