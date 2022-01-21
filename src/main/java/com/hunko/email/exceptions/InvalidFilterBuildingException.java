package com.hunko.email.exceptions;

public class InvalidFilterBuildingException extends RuntimeException{
    public InvalidFilterBuildingException() {
    }

    public InvalidFilterBuildingException(String message) {
        super(message);
    }

    public InvalidFilterBuildingException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidFilterBuildingException(Throwable cause) {
        super(cause);
    }
}
