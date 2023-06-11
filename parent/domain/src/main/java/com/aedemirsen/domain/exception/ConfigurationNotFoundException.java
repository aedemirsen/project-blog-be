package com.aedemirsen.domain.exception;

import com.aedemirsen.domain.utils.constants.ErrorCodes;

public class ConfigurationNotFoundException extends NotFoundException {

    public ConfigurationNotFoundException() {
        super(ErrorCodes.RECORD_NOT_FOUND);
    }

    public ConfigurationNotFoundException(String message) {
        super(message, ErrorCodes.RECORD_NOT_FOUND);
    }
}
