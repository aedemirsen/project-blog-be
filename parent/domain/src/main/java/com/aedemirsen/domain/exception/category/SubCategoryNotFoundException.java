package com.aedemirsen.domain.exception.category;

import com.aedemirsen.domain.exception.NotFoundException;
import com.aedemirsen.domain.utils.constants.ErrorCodes;

public class SubCategoryNotFoundException extends NotFoundException {
    public SubCategoryNotFoundException() {
        super(ErrorCodes.CATEGORY_NOT_FOUND);
    }

    public SubCategoryNotFoundException(String message) {
        super(message, ErrorCodes.CATEGORY_NOT_FOUND);
    }
}
