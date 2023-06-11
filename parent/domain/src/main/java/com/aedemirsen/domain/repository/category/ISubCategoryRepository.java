package com.aedemirsen.domain.repository.category;

import com.aedemirsen.domain.entity.category.SubCategory;
import com.aedemirsen.domain.repository.base.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ISubCategoryRepository extends BaseRepository<SubCategory,Long> {
    Optional<SubCategory> findByName(String name);
}
