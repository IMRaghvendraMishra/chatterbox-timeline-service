package com.chatterbox.timelineservice.kafka;

import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * This service will consumer messages from chatterbox-posts topic.
 * This consumer can help to maintain recent posts from users
 */
@Service
@Log4j2
public class PostEventConsumer {
    @KafkaListener(topics = "${spring.kafka.post-events-topic-name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumePostEvent(String message) {
        log.info("Received post event from Kafka: {}", message);
    }
}
