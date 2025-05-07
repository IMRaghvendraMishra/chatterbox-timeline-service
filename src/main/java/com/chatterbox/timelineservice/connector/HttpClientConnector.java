package com.chatterbox.timelineservice.connector;

import com.chatterbox.timelineservice.exception.PostException;
import com.chatterbox.timelineservice.record.Post;
import com.chatterbox.timelineservice.util.ObjectJsonMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Fetches posts for a given username from the Post Service using Reactor Netty.
 */
@Component
@RequiredArgsConstructor
@Log4j2
public class HttpClientConnector {

    @Value("${timeline-service.connector.post-service.get-posts-by-username-endpoint}")
    private String getByUsernameAPIEndpoint;

    private final ObjectJsonMapper mapper;

    public Optional<List<Post>> getPosts(String username) {
        String uri = buildUri(username);

        try {
            String responseBody = HttpClient.create()
                    .headers(h -> h.add("Accept", "application/json"))
                    .get()
                    .uri(uri)
                    .responseSingle((res, content) -> {
                        if (res.status().code() >= 400) {
                            return Mono.error(new PostException("Failed to fetch posts for user: " + username +
                                    ". Status: " + res.status().code()));
                        }
                        return content.asString();
                    })
                    .block(Duration.ofSeconds(30));

            if (responseBody == null || responseBody.isBlank()) {
                log.warn("Empty response received from Post Service for user '{}'", username);
                return Optional.of(Collections.emptyList());
            }

            return mapper.jsonToPosts(responseBody);

        } catch (Exception ex) {
            log.error("Error calling Post Service at '{}': {}", uri, ex.getMessage(), ex);
            throw new PostException("Unable to fetch posts for user: " + username);
        }
    }

    private String buildUri(String username) {
        return String.format("%s%s", getByUsernameAPIEndpoint, username);
    }
}
