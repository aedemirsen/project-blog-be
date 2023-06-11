package com.aedemirsen.domain.service.impl.article;

import com.aedemirsen.domain.entity.article.Article;
import com.aedemirsen.domain.exception.DuplicateDataException;
import com.aedemirsen.domain.exception.author.AuthorNotFoundException;
import com.aedemirsen.domain.repository.article.IArticleRepository;
import com.aedemirsen.domain.service.interfaces.article.IArticleService;
import com.aedemirsen.domain.service.interfaces.author.IAuthorService;
import com.aedemirsen.domain.utils.constants.ErrorCodes;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ArticleService implements IArticleService {

    private final IArticleRepository articleRepository;
    private final IAuthorService authorService;

    @Override
    public Article save(Article article) {
        var author = authorService.findByUsername(article.getAuthorUsername());
        if (author == null) throw new AuthorNotFoundException();
        var existingArticle = articleRepository.findByTitle(article.getTitle());
        if (existingArticle != null) throw new DuplicateDataException(ErrorCodes.DUPLICATE_ARTICLE_TITLE);
        return articleRepository.save(article);
    }

    @Override
    public Page<Article> findAll(Pageable pageable) {
        return articleRepository.findAll(pageable);
    }

    @Override
    public List<Article> findAll() {
        return articleRepository.findAll();
    }
}
