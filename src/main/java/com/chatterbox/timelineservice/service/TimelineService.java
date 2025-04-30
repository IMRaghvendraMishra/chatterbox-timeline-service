package com.chatterbox.timelineservice.service;

import com.chatterbox.timelineservice.model.Post;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class TimelineService {

    public List<Post> getUserTimeline(String userId) {
        // Mock posts
        return List.of(
                new Post("p1", userId, "First post!", Instant.now()),
                new Post("p2", userId, "Second post!", Instant.now())
        );
    }
}