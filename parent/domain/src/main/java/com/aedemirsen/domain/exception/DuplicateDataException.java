package com.aedemirsen.domain.exception;

import com.aedemirsen.domain.utils.constants.ErrorCodes;

public class DuplicateDataException extends BaseException{
    public DuplicateDataException(){super(ErrorCodes.DUPLICATE_DATA);}

    public DuplicateDataException(String message){super(ErrorCodes.DUPLICATE_DATA,message);}
}
