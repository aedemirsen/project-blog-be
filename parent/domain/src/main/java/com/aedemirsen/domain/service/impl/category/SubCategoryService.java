package com.aedemirsen.domain.service.impl.category;

import com.aedemirsen.domain.entity.category.SubCategory;
import com.aedemirsen.domain.repository.category.ISubCategoryRepository;
import com.aedemirsen.domain.service.interfaces.category.ISubCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SubCategoryService implements ISubCategoryService {

    private final ISubCategoryRepository subCategoryRepository;
    @Override
    public SubCategory save(SubCategory subCategory) {
        return subCategoryRepository.save(subCategory);
    }
}
