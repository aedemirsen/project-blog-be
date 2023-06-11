package com.aedemirsen.domain.exception.author;

import com.aedemirsen.domain.exception.NotFoundException;
import com.aedemirsen.domain.utils.constants.ErrorCodes;

public class AuthorNotFoundException extends NotFoundException {
    public AuthorNotFoundException() {
        super(ErrorCodes.AUTHOR_NOT_FOUND);
    }

    public AuthorNotFoundException(String message) {
        super(message, ErrorCodes.AUTHOR_NOT_FOUND);
    }

}
