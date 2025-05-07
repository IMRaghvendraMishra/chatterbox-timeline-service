package com.chatterbox.timelineservice.service;

import com.chatterbox.timelineservice.connector.HttpClientConnector;
import com.chatterbox.timelineservice.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TimelineService {

    private final HttpClientConnector httpClientConnector;

    public List<Post> getUserTimeline(String username) {
        return httpClientConnector.getPosts(username)
                .map(posts -> posts.stream()
                        .sorted(Comparator.comparing(Post::timestamp).reversed()) // Most recent first
                        .limit(10)
                        .collect(Collectors.toList()))
                .orElse(Collections.emptyList());
    }
}
