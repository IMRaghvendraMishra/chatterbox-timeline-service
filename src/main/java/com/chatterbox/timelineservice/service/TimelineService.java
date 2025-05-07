package com.chatterbox.timelineservice.service;

import com.chatterbox.timelineservice.connector.HttpClientConnector;
import com.chatterbox.timelineservice.record.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service for managing user timelines.
 * This service fetches posts for a user and sorts them in descending order of timestamp,
 * providing the most recent 10 posts.
 */
@Service
@RequiredArgsConstructor
public class TimelineService {

    private final HttpClientConnector httpClientConnector;

    /**
     * Retrieves the user's timeline, consisting of the 10 most recent posts.
     *
     * @param username the username for which to retrieve the timeline
     * @return a list of the 10 most recent {@link Post} objects
     */
    public List<Post> getUserTimeline(String username) {
        return httpClientConnector.getPosts(username)
                .map(posts -> posts.stream()
                        .sorted(Comparator.comparing(Post::timestamp).reversed()) // Sort by timestamp (most recent first)
                        .limit(10)  // Limit the result to 10 posts
                        .collect(Collectors.toList()))
                .orElse(Collections.emptyList());  // Return empty list if no posts found
    }
}
