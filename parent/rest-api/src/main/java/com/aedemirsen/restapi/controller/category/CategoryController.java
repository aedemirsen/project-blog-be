package com.aedemirsen.restapi.controller.category;

import com.aedemirsen.core.payload.GenericResponse;
import com.aedemirsen.domain.entity.category.Category;
import com.aedemirsen.domain.entity.category.SubCategory;
import com.aedemirsen.domain.service.interfaces.category.ICategoryService;
import com.aedemirsen.restapi.dto.category.CategoryDto;
import com.aedemirsen.restapi.dto.category.SubCategoryDto;
import com.aedemirsen.restapi.mapper.category.ICategoryMapper;
import com.aedemirsen.restapi.mapper.category.ISubCategoryMapper;
import com.aedemirsen.restapi.utils.constants.Apis;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(Apis.Category.BASE_URL)
public class CategoryController {

    private final ICategoryMapper categoryMapper;
    private final ICategoryService categoryService;
    private final ISubCategoryMapper subCategoryMapper;

    @Operation(
            summary = "Adds a new category",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Add Category"),
            responses = {
                    @ApiResponse(description = "Category inserted.", responseCode = "200")
            }
    )
    @PostMapping("/")
    public GenericResponse<CategoryDto> saveCategory(@Valid @RequestBody CategoryDto categoryDto) {
        Category mappedCategory = categoryMapper.toCategory(categoryDto);
        var insertedCategory = categoryService.save(mappedCategory);
        return GenericResponse.<CategoryDto>builder()
                .success(Boolean.TRUE)
                .data(categoryMapper.fromCategory(insertedCategory))
                .build();
    }

    @Operation(
            summary = "Adds a new sub category to specified category",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Add Sub Category"),
            responses = {
                    @ApiResponse(description = "SubCategory inserted.", responseCode = "200")
            }
    )
    @PostMapping("/{categoryId}/sub_categories")
    public GenericResponse<SubCategoryDto> saveSubCategory(@PathVariable long categoryId, @Valid @RequestBody SubCategoryDto subCategoryDto) {
        SubCategory mappedSubCategory = subCategoryMapper.toSubCategory(subCategoryDto);
        var insertedSubCategory = categoryService.addSubCategory(categoryId,mappedSubCategory);
        return GenericResponse.<SubCategoryDto>builder()
                .success(Boolean.TRUE)
                .data(subCategoryMapper.fromSubCategory(insertedSubCategory))
                .build();
    }

    @Operation(
            summary = "returns all the categories in the database.",
            responses = {
                    @ApiResponse(description = "Categories", responseCode = "200")
            },
            parameters = {
                    @Parameter(name = "pageable query", in = ParameterIn.PATH, description = "Gets categories by paging rules."),
            }
    )
    @GetMapping("/")
    public List<CategoryDto> getCategories(@ParameterObject Pageable pageable) {
        return categoryService.findAll(pageable).stream().map(categoryMapper::fromCategory).collect(Collectors.toList());
    }
}
