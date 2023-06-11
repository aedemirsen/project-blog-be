package com.aedemirsen.domain.exception.category;

import com.aedemirsen.domain.exception.NotFoundException;
import com.aedemirsen.domain.utils.constants.ErrorCodes;

public class CategoryNotFoundException extends NotFoundException {
    public CategoryNotFoundException() {
        super(ErrorCodes.CATEGORY_NOT_FOUND);
    }

    public CategoryNotFoundException(String message) {
        super(message, ErrorCodes.CATEGORY_NOT_FOUND);
    }
}
