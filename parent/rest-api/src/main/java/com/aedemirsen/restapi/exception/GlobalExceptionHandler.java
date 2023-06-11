package com.aedemirsen.restapi.exception;

import com.aedemirsen.core.payload.GenericResponse;
import com.aedemirsen.domain.exception.BaseException;
import com.aedemirsen.domain.exception.DuplicateDataException;
import com.aedemirsen.domain.exception.author.AuthorNotFoundException;
import com.aedemirsen.domain.exception.category.CategoryNotFoundException;
import com.aedemirsen.domain.service.interfaces.i18n.II18nMessageService;
import com.aedemirsen.domain.utils.constants.I18nConstants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    private final II18nMessageService messageService;

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<GenericResponse<Object>> handleAuthenticationException(AuthenticationException exception) {
        //log.error(LoggerConstants.LOG_MESSAGE_ERROR_LOG, exception);
        String errorMessage = messageService
                .getMessage(I18nConstants.LOGIN_BAD_CREDENTIALS, LocaleContextHolder.getLocale());
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(GenericResponse.builder()
                        .success(false)
                        .message(errorMessage)
                        .build());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<GenericResponse<Object>> handleValidationException(MethodArgumentNotValidException exception) {
        //log.error(LoggerConstants.LOG_MESSAGE_ERROR_LOG, exception);

        List<ObjectError> errors = exception.getBindingResult().getAllErrors().stream()
                .filter(i -> i.getDefaultMessage() != null).collect(Collectors.toList());

        List<String> errorMessages = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(errors)) {
            errorMessages.addAll(
                    errors.stream().map(ObjectError::getDefaultMessage)
                            .filter(Objects::nonNull)
                            .collect(Collectors.toList())
            );
        }
        errorMessages.add(messageService
                .getMessage(I18nConstants.GLOBAL_VALIDATION_ERROR, LocaleContextHolder.getLocale()));

        return ResponseEntity
                .badRequest()
                .body(GenericResponse
                        .builder()
                        .success(false)
                        .message(errorMessages.get(0))
                        .data(errorMessages)
                        .build());
    }

    @ExceptionHandler({Throwable.class})
    public ResponseEntity<GenericResponse<Object>> handleGenericException(Throwable throwable) {
       // log.error(throwable.getMessage(), throwable);
        String errorMessage = messageService
                .getMessage(I18nConstants.GLOBAL_UNHANDLED_ERROR, LocaleContextHolder.getLocale());
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(GenericResponse
                        .builder()
                        .success(false)
                        .message(errorMessage)
                        .build());
    }

    @ExceptionHandler({AuthorNotFoundException.class})
    public ResponseEntity<GenericResponse<Object>> handleAuthorNotFoundException(AuthorNotFoundException exception) {
       // log.error(LoggerConstants.LOG_MESSAGE_ERROR_LOG, exception);
        String errorMessage = messageService
                .getMessage(I18nConstants.AUTHOR_NOT_FOUND, LocaleContextHolder.getLocale());
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(GenericResponse.builder()
                        .success(false)
                        .message(errorMessage)
                        .data(exception.getErrorCode())
                        .build()
                );
    }

    @ExceptionHandler({CategoryNotFoundException.class})
    public ResponseEntity<GenericResponse<Object>> handleCategoryNotFoundException(CategoryNotFoundException exception) {
        // log.error(LoggerConstants.LOG_MESSAGE_ERROR_LOG, exception);
        String errorMessage = messageService
                .getMessage(I18nConstants.CATEGORY_NOT_FOUND, LocaleContextHolder.getLocale());
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(GenericResponse.builder()
                        .success(false)
                        .message(errorMessage)
                        .data(exception.getErrorCode())
                        .build()
                );
    }

    @ExceptionHandler({DuplicateDataException.class})
    public ResponseEntity<GenericResponse<Object>> handleDuplicateDataException(DuplicateDataException exception) {
        // log.error(LoggerConstants.LOG_MESSAGE_ERROR_LOG, exception);
        String errorMessage = messageService
                .getMessage(I18nConstants.DUPLICATE_DATA_FOUND, LocaleContextHolder.getLocale());
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(GenericResponse.builder()
                        .success(false)
                        .message(errorMessage)
                        .data(exception.getErrorCode())
                        .build()
                );
    }

    @ExceptionHandler({BaseException.class})
    public ResponseEntity<GenericResponse<Object>> handleBaseException(BaseException exception) {
        //log.error(LoggerConstants.LOG_MESSAGE_ERROR_LOG, exception);
        String errorMessage = messageService.getMessage(exception.getErrorCode()
                , LocaleContextHolder.getLocale()
                , exception.getArgs());
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(GenericResponse.builder()
                        .success(false)
                        .message(errorMessage)
                        .data(exception.getErrorCode())
                        .build()
                );
    }
}
