package com.aedemirsen.domain.entity;

import com.aedemirsen.domain.entity.enums.config.ConfigurationDataType;
import com.aedemirsen.domain.entity.enums.config.ConfigurationName;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
@ToString
@Table(name = "configuration")
public class Configuration extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private ConfigurationName name;

    @Enumerated(EnumType.STRING)
    private ConfigurationDataType dataTpe;

    private String value;
}
