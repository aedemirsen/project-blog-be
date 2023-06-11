package com.aedemirsen.restapi.dto.file;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
@EqualsAndHashCode
@ToString(callSuper = true)
public class FileDto {

    @NotNull
    private String uuid;

    @NotNull
    private String fileName;

    private String description;

    @NotNull
    private String mimeType;

    @NotNull
    private double fileSize;

    private Integer width;

    private Integer height;

    private Boolean deleted = false;
}
