package com.aedemirsen.domain.utils.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ErrorCodes {

    public static final String AUTHOR_NOT_FOUND = "E100";

    public static final String INVALID_DATA_TYPE = "E101";

    public static final String RECORD_NOT_FOUND = "E102";

    public static final String DUPLICATE_DATA = "E103";

    public static final String LOGIN_BAD_CREDENTIALS = "E104";
    public static final String USERNAME_EMPTY = "E105";
    public static final String PASSWORD_EMPTY = "E106";
    public static final String GLOBAL_VALIDATION_ERROR = "E107";
    public static final String GLOBAL_UNHANDLED_ERROR = "E108";
    public static final String AUTH_ACCESS_DENIED = "E109";
    public static final String UNAUTHORIZED = "E110";

    public static final String DUPLICATE_ARTICLE_TITLE = "E111";

    public static final String CATEGORY_NOT_FOUND = "E112";

    public static final String DUPLICATE_SUB_CATEGORY = "E113";



}

