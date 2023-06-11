package com.aedemirsen.domain.repository.category;

import com.aedemirsen.domain.entity.category.Category;
import com.aedemirsen.domain.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends BaseRepository<Category,Long> {

    @Query("SELECT c " +
            "FROM Category c " +
            " WHERE" +
            "  c.id = (SELECT s.id FROM SubCategory s where s.name = :subCategoryName) ")
    Category findBySubCategoryName(@Param("subCategoryName") String subCategoryName);

}
