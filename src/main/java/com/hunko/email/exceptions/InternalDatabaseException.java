package com.hunko.email.exceptions;

/**
 * exception happened in database and caused by developers
 */
public class InternalDatabaseException extends RuntimeException {
    public InternalDatabaseException() {
    }

    public InternalDatabaseException(String message) {
        super(message);
    }

    public InternalDatabaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public InternalDatabaseException(Throwable cause) {
        super(cause);
    }
}
