package com.chatterbox.timelineservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class ChatterboxTimelineServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ChatterboxTimelineServiceApplication.class, args);
    }
}