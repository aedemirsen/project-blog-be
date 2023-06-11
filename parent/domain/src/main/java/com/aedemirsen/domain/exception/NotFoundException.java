package com.aedemirsen.domain.exception;

public class NotFoundException extends BaseException{
    public NotFoundException(String message, Throwable cause, String errorCode, Object... args) {
        super(message, cause, errorCode, args);
    }

    public NotFoundException(String message, String errorCode, Object... args) {
        super(message, errorCode, args);
    }

    public NotFoundException(String errorCode, Object... args) {
        super(errorCode, args);
    }
}
