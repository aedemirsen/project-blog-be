package com.aedemirsen.domain.service.impl.i18n;

import com.aedemirsen.domain.service.interfaces.i18n.II18nMessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Service
public class I18nMessageServiceImpl implements II18nMessageService {

    private final MessageSource messageSource;

    @Override
    public String getMessage(String code, Locale locale, Object... args) {
        return getMessageWithParam(code, args, locale);
    }

    @Override
    public String getMessage(String code, Object[] args, Locale locale) {
        return getMessageWithParam(code, args, locale);
    }

    private String getMessageWithParam(String code, Object[] args, Locale locale) {
        try {
            return messageSource.getMessage(code, args, locale);
        } catch (NoSuchMessageException exception) {
            log.error(String.format("No message found for code: %s", code), exception);
        }
        return "";
    }
}
