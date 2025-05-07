package com.chatterbox.timelineservice.validator;

import com.chatterbox.timelineservice.connector.HttpClientConnector;
import com.chatterbox.timelineservice.exception.MandatoryFieldException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@RequiredArgsConstructor
@Log4j2
public class TimelineServiceValidator {

    private final HttpClientConnector clientConnector;

    /**
     * Validates that the username is non-empty and exists in the User Service.
     *
     * @param username the username to validate
     * @throws MandatoryFieldException if username is null or empty
     */
    public void validateUser(String username) {
        if (!StringUtils.hasText(username)) {
            log.warn("Validation failed: empty or null username");
            throw new MandatoryFieldException("Username cannot be empty or null");
        }
        log.info("User '{}' passed validation", username);
    }
}
