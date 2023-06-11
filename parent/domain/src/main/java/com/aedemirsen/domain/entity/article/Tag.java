package com.aedemirsen.domain.entity.article;

import com.aedemirsen.domain.entity.BaseEntity;
import lombok.*;
import javax.persistence.Entity;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Tag extends BaseEntity {

    private String tagName;

}
