package com.aedemirsen.domain.entity.category;

import com.aedemirsen.domain.entity.BaseEntity;
import lombok.*;
import javax.persistence.*;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table
public class Category extends BaseEntity {

    @Column(unique = true)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "category_id")
    private Collection<SubCategory> subCategories;

    public void addSubCategory(SubCategory subCategory){
        this.subCategories.add(subCategory);
    }

}
