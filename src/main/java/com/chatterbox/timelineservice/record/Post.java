package com.chatterbox.timelineservice.record;

import java.time.Instant;

public record Post(String postId, String username, String content, Instant timestamp) {}
