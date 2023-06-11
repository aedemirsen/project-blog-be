package com.aedemirsen.restapi.dto.article;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
public class CodeBlockDto {

    private String programmingLanguage;
    private String codeBlockBody;
    private String description;
}
