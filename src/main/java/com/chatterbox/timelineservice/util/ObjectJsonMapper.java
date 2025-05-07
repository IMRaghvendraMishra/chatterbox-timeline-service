package com.chatterbox.timelineservice.util;

import com.chatterbox.timelineservice.model.Post;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Utility class for serializing and deserializing JSON using Jackson.
 */
@Component
@RequiredArgsConstructor
@Log4j2
public class ObjectJsonMapper {

    private final ObjectMapper objectMapper;

    public Optional<List<Post>> jsonToPosts(String json) {
        try {
            return Optional.ofNullable(objectMapper.readValue(json, new TypeReference<>() {}));
        } catch (JsonProcessingException e) {
            log.error("Unable to parse JSON to Post list", e);
            return Optional.empty();
        }
    }
}
