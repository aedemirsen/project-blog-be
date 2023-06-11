package com.aedemirsen.domain.service.impl.category;

import com.aedemirsen.domain.entity.category.Category;
import com.aedemirsen.domain.entity.category.SubCategory;
import com.aedemirsen.domain.exception.DuplicateDataException;
import com.aedemirsen.domain.exception.category.CategoryNotFoundException;
import com.aedemirsen.domain.repository.category.ICategoryRepository;
import com.aedemirsen.domain.repository.category.ISubCategoryRepository;
import com.aedemirsen.domain.service.interfaces.category.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class CategoryService implements ICategoryService {

    private final ICategoryRepository categoryRepository;
    private final ISubCategoryRepository subCategoryRepository;

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Page<Category> findAll(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public SubCategory addSubCategory(long categoryId, SubCategory subCategory) {
        //check whether specified category already exists, if it does not exist throw exception
        Category category = categoryRepository.findById(categoryId).orElseThrow(CategoryNotFoundException::new);
        //check if sub category already exists, if it exists throw exception,if it does not then we can add new sub category
        SubCategory existingSubCategory = subCategoryRepository.findByName(subCategory.getName()).orElse(null);
        if (existingSubCategory != null)
            throw new DuplicateDataException();
        category.addSubCategory(subCategory);
        //subCategoryRepository.save(subCategory);
        categoryRepository.save(category);
        return subCategory;
    }
}
