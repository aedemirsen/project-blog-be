package com.aedemirsen.restapi.dto.category;

import com.aedemirsen.domain.entity.category.SubCategory;
import com.aedemirsen.restapi.dto.BaseDto;
import lombok.*;
import lombok.experimental.SuperBuilder;
import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
public class CategoryDto extends BaseDto {

    private String name;
    private Collection<SubCategory> subCategories;

}
