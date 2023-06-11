package com.aedemirsen.restapi.mapper.category;

import com.aedemirsen.domain.entity.category.Category;
import com.aedemirsen.restapi.dto.category.CategoryDto;
import org.mapstruct.Mapper;

@Mapper(uses = {ISubCategoryMapper.class},componentModel = "spring")
public interface ICategoryMapper {

    Category toCategory(CategoryDto categoryDto);

    CategoryDto fromCategory(Category category);
}
