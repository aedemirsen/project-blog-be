package com.aedemirsen.restapi.mapper.category;

import com.aedemirsen.domain.entity.category.SubCategory;
import com.aedemirsen.restapi.dto.category.SubCategoryDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ISubCategoryMapper {

    SubCategory toSubCategory(SubCategoryDto subCategoryDto);

    SubCategoryDto fromSubCategory(SubCategory subCategory);

}
