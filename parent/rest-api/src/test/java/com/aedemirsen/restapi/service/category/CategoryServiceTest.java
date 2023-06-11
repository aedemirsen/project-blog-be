package com.aedemirsen.restapi.service.category;

import com.aedemirsen.domain.entity.article.Article;
import com.aedemirsen.domain.entity.author.Author;
import com.aedemirsen.domain.entity.category.Category;
import com.aedemirsen.domain.entity.category.SubCategory;
import com.aedemirsen.domain.repository.article.IArticleRepository;
import com.aedemirsen.domain.repository.category.ICategoryRepository;
import com.aedemirsen.domain.service.impl.article.ArticleService;
import com.aedemirsen.domain.service.impl.category.CategoryService;
import com.aedemirsen.domain.service.interfaces.author.IAuthorService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {

    @Mock
    private ICategoryRepository categoryRepository;
//    @Mock
//    private IAuthorService authorService;

    @InjectMocks
    private CategoryService categoryService;

    private static List<Category> categories;

    @BeforeAll
    static void setUp() {
        List<SubCategory> subCategories = Collections.singletonList(SubCategory.builder().name("Sub Category").build());
        categories = Arrays.asList(
                Category.builder().name("Category 1").subCategories(subCategories).build(),
                Category.builder().name("Category 2").subCategories(subCategories).build(),
                Category.builder().name("Category 3").subCategories(subCategories).build()
        );
    }

    @Test
    void save() {
        Category category = Category.builder().name("Category 1")
                .subCategories(Collections.singletonList(SubCategory.builder().name("Sub Category").build()))
                .build();


    }

    @Test
    void shouldFindAllCategories() {
        when(categoryRepository.findAll()).thenReturn(categories);

        List<Category> result = categoryRepository.findAll();

        assertThat(categories.size()).isEqualTo(result.size());
        assertThat(categories).isEqualTo(result);

        verify(categoryRepository).findAll();
    }

    @Test
    void shouldFindAllCategoriesByPageableArgument() {
        int pageNumber = 0;
        int pageSize = 2;
        int totalElements = categories.size();

        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        Page<Category> page = new PageImpl<>(categories, pageRequest, totalElements);

        when(categoryRepository.findAll(pageRequest)).thenReturn(page);

        Page<Category> result = categoryService.findAll(pageRequest);

        assertThat(categories.size()).isEqualTo(result.getContent().size());

        assertThat("Category 1").isEqualTo(result.getContent().get(0).getName());
        assertThat("Category 2").isEqualTo(result.getContent().get(1).getName());
        assertThat("Category 3").isEqualTo(result.getContent().get(2).getName());
        assertThat(pageNumber).isEqualTo(result.getNumber());
        assertThat(pageSize).isEqualTo(result.getSize());
        assertThat(totalElements).isEqualTo(result.getTotalElements());

        verify(categoryRepository).findAll(pageRequest);
    }
}
