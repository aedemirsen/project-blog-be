package com.aedemirsen.domain.repository;

import com.aedemirsen.domain.entity.Configuration;
import com.aedemirsen.domain.entity.enums.config.ConfigurationName;
import com.aedemirsen.domain.repository.base.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IConfigurationRepository extends BaseRepository<Configuration, Long> {

    Configuration findByName(ConfigurationName configurationName);
}
