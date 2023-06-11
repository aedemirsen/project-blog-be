package com.aedemirsen.restapi.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class BaseDto{
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
