package com.chatterbox.timelineservice.exception;

/**
 * Thrown to indicate that a required field is missing or null.
 */
public class MandatoryFieldException extends RuntimeException {

    /**
     * Constructs a new MandatoryFieldException with the specified detail message.
     *
     * @param message the detail message
     */
    public MandatoryFieldException(String message) {
        super(message);
    }

    /**
     * Constructs a new MandatoryFieldException with the specified detail message and cause.
     *
     * @param message the detail message
     * @param cause the cause of the exception
     */
    public MandatoryFieldException(String message, Throwable cause) {
        super(message, cause);
    }
}
