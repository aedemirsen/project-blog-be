package com.aedemirsen.domain.entity.article;

import com.aedemirsen.domain.entity.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table
public class CodeBlock extends BaseEntity {

    private String programmingLanguage;
    private String codeBlockBody;
    private String description;
}
