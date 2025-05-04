package com.chatterbox.timelineservice.service;

import com.chatterbox.timelineservice.model.Post;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class TimelineService {

    public List<Post> getUserTimeline(String userId) {
        // TODO:
        // invoke follower service get userId's following and generate feed of top 20 post
        // 20 could be configurable?
        // Mock posts
        // Communicates with Follower Service to get list of followed users
        //Queries Post Service for recent posts from followed users
        return List.of(
                new Post("p1", userId, "First post!", Instant.now()),
                new Post("p2", userId, "Second post!", Instant.now())
        );
    }
}