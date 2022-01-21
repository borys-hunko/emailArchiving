package com.hunko.email.exceptions;

public class NullAttributeException extends RuntimeException{
    public NullAttributeException() {
    }

    public NullAttributeException(String message) {
        super(message);
    }

    public NullAttributeException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullAttributeException(Throwable cause) {
        super(cause);
    }

    public NullAttributeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
