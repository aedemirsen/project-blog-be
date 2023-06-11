package com.aedemirsen.restapi.repository.category;

import com.aedemirsen.domain.entity.category.Category;
import com.aedemirsen.domain.entity.category.SubCategory;
import com.aedemirsen.domain.repository.category.ICategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class CategoryRepositoryTest {

    @Autowired
    private ICategoryRepository categoryRepository;

    @Test
    void findsCategoryBySubCategoryName(){
        String subCategoryName = "subCategory";
        SubCategory subCategory = SubCategory.builder().name(subCategoryName).build();

        Category category = Category.builder()
                .name("category1")
                .subCategories(List.of(subCategory))
                .build();

        categoryRepository.save(category);

        Category c = categoryRepository.findBySubCategoryName(subCategoryName);
        assertThat(c).isEqualTo(category);
    }

}
