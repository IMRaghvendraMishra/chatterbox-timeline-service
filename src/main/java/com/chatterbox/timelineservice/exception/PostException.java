package com.chatterbox.timelineservice.exception;

/**
 * Thrown to indicate an error occurred while processing posts in the timeline service.
 */
public class PostException extends RuntimeException {

    /**
     * Constructs a new PostException with the specified detail message.
     *
     * @param message the detail message
     */
    public PostException(String message) {
        super(message);
    }

    /**
     * Constructs a new PostException with the specified detail message and cause.
     *
     * @param message the detail message
     * @param cause the cause of the exception
     */
    public PostException(String message, Throwable cause) {
        super(message, cause);
    }
}
