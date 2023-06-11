package com.aedemirsen.domain.service.impl;

import com.aedemirsen.domain.caches.CacheNames;
import com.aedemirsen.domain.entity.Configuration;
import com.aedemirsen.domain.entity.enums.config.ConfigurationName;
import com.aedemirsen.domain.exception.ConfigurationNotFoundException;
import com.aedemirsen.domain.model.commons.TimeBasedConfiguration;
import com.aedemirsen.domain.repository.IConfigurationRepository;
import com.aedemirsen.domain.service.interfaces.IConfigurationService;
import com.aedemirsen.domain.utils.ConfigurationUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ConfigurationService implements IConfigurationService {

    private final IConfigurationRepository configurationRepository;

    @Override
    public Configuration findByName(ConfigurationName configurationName) {
        return Objects.requireNonNull(configurationRepository.findByName(configurationName));
    }

    @Override
    public String findByName(ConfigurationName configurationName, String defaultValue) {
        try {
            Configuration configuration = findByName(configurationName);
            return configuration.getValue();
        } catch (Exception e) {
            if (defaultValue != null) {
                return defaultValue;
            }
            throw e;
        }
    }

    @Cacheable(value = CacheNames.CONFIGURATIONS, key = "#configurationName")
    @Override
    public String findCachedValueByName(ConfigurationName configurationName, String defaultValue) {
        return findByName(configurationName, defaultValue);
    }

    @Override
    public TimeBasedConfiguration findTimeBasedConfigurationByName(ConfigurationName configurationName) {
        var configuration = findByName(configurationName);
        return TimeBasedConfiguration.builder()
                .unit(ConfigurationUtils.getTimeUnit(configuration))
                .value(Long.parseLong(configuration.getValue()))
                .build();
    }

    @Override
    public Configuration findByNameOrThrow(ConfigurationName configurationName) {

        return Optional.ofNullable(configurationRepository.findByName(configurationName))
                .orElseThrow(ConfigurationNotFoundException::new);
    }
}
