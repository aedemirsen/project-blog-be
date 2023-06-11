package com.aedemirsen.restapi.utils.constants;

public class TextStyleIndicator {

    public static final String BOLD = "b";
    public static final String ITALIC = "i";
    public static final String UNDERLINED = "u";
    public static final String HEADER1 = "h1"; // font x
    public static final String HEADER2 = "h2"; // font y
    public static final String HEADER3 = "h3"; // font z
    public static final String HEADER4 = "h4"; // font w
    public static final String EMBEDDED_URL = "url";
    public static final String CODE_SECTION = "code";

    public static String buildExpression(String c){
        String wrapper = "₺";
        return wrapper + c + wrapper;
    }
}




