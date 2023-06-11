package com.aedemirsen.domain.service.interfaces.category;

import com.aedemirsen.domain.entity.category.Category;
import com.aedemirsen.domain.entity.category.SubCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
public interface ICategoryService {
    Category save(Category category);

    Page<Category> findAll(Pageable pageable);

    SubCategory addSubCategory(long categoryId, SubCategory subCategory);
}
