package com.aedemirsen.domain.service.interfaces;

import com.aedemirsen.domain.entity.Configuration;
import com.aedemirsen.domain.entity.enums.config.ConfigurationName;
import com.aedemirsen.domain.model.commons.TimeBasedConfiguration;

public interface IConfigurationService {

    Configuration findByName(ConfigurationName configurationName);

    String findByName(ConfigurationName configurationName, String defaultValue);

    String findCachedValueByName(ConfigurationName configurationName, String defaultValue);

    TimeBasedConfiguration findTimeBasedConfigurationByName(ConfigurationName configurationName);

    Configuration findByNameOrThrow(ConfigurationName configurationName);
}

