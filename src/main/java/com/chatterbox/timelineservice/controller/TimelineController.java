package com.chatterbox.timelineservice.controller;

import com.chatterbox.timelineservice.record.Post;
import com.chatterbox.timelineservice.service.TimelineService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing user timelines.
 * Exposes endpoints for retrieving a user's timeline based on username.
 *
 * Example usage:
 * GET /api/timeline/johndoe → Returns a list of the 10 most recent posts for user 'johndoe'.
 */
@RestController
@RequestMapping("/api/timeline")
@RequiredArgsConstructor
public class TimelineController {

    private final TimelineService timelineService;

    /**
     * Retrieves the most recent posts in a user's timeline.
     *
     * @param username the username whose timeline is to be fetched
     * @return a list of recent {@link Post} objects
     */
    @GetMapping("/{username}")
    public List<Post> getTimeline(@PathVariable String username) {
        return timelineService.getUserTimeline(username);
    }
}
