package com.aedemirsen.restapi.utils.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Apis {

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Article {
        public static final String BASE_URL = "/article";

    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Category {
        public static final String BASE_URL = "/category";

    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Author {
        public static final String BASE_URL = "/author";

    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class File {
        public static final String BASE_URL = "/file";
        public static final String UPLOAD_FILE = "/upload-file";
        public static final String FILE_SERVER_SECRET = "/s";
    }
}
