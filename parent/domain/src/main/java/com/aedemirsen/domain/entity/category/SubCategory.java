package com.aedemirsen.domain.entity.category;

import com.aedemirsen.domain.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table
public class SubCategory extends BaseEntity {

    @Column(unique = true)
    private String name;

}
