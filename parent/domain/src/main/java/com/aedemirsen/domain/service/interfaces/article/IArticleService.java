package com.aedemirsen.domain.service.interfaces.article;

import com.aedemirsen.domain.entity.article.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IArticleService {

    Article save(Article article);

    Page<Article> findAll(Pageable pageable);

    List<Article> findAll();
}


