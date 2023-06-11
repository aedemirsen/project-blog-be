package com.aedemirsen.domain.service.interfaces.i18n;

import java.util.Locale;
import java.util.Map;

public interface II18nMessageService {

    String getMessage(String code, Locale locale, Object... args);

    String getMessage(String code, Object[] args, Locale locale);
//
//    String getMessageFromResourceCode(String code, Locale locale);
//
//    String getParameterizedMessageFromResourceCode(String code, Map<String, String> params, Locale locale);
}
