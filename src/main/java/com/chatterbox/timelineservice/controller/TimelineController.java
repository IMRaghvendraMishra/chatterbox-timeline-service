package com.chatterbox.timelineservice.controller;

import com.chatterbox.timelineservice.model.Post;
import com.chatterbox.timelineservice.service.TimelineService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/timeline")
@AllArgsConstructor
public class TimelineController {

    private final TimelineService timelineService;

    @GetMapping("/{userId}")
    public List<Post> getTimeline(@PathVariable String userId) {
        return timelineService.getUserTimeline(userId);
    }
}