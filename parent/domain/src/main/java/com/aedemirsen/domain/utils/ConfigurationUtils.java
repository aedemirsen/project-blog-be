package com.aedemirsen.domain.utils;

import com.aedemirsen.domain.entity.Configuration;
import com.aedemirsen.domain.entity.enums.config.ConfigurationDataType;
import com.aedemirsen.domain.exception.InvalidDataTypeException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.temporal.ChronoUnit;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ConfigurationUtils {

    public static void dataTypeChecker(Configuration configuration, ConfigurationDataType configurationDataType)
            throws InvalidDataTypeException {
        boolean empty = configuration == null;
        if (empty || configuration.getDataTpe() == configurationDataType) {
            return;
        }
        throw new InvalidDataTypeException();
    }

    public static ChronoUnit getTimeUnit(Configuration configuration) {
        return ChronoUnit.valueOf(configuration.getDataTpe().name());
    }
}
