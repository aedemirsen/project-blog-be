package com.aedemirsen.domain.repository.article;

import com.aedemirsen.domain.entity.article.Article;
import com.aedemirsen.domain.repository.base.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IArticleRepository extends BaseRepository<Article,Long> {

    Article findByTitle(String title);
}
