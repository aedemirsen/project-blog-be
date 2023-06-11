package com.aedemirsen.domain.model.commons;

import lombok.Builder;
import lombok.Getter;

import java.time.temporal.ChronoUnit;

@Builder
@Getter
public class TimeBasedConfiguration {

    private final ChronoUnit unit;
    private final long value;
}
