package com.aedemirsen.domain.exception;

import com.aedemirsen.domain.utils.constants.ErrorCodes;

public class InvalidDataTypeException extends BaseException {

    public InvalidDataTypeException() {
        super(ErrorCodes.INVALID_DATA_TYPE);
    }

    public InvalidDataTypeException(String message) {
        super(message, ErrorCodes.INVALID_DATA_TYPE);
    }
}
