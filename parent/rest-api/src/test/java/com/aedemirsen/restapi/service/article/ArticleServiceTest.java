package com.aedemirsen.restapi.service.article;

import com.aedemirsen.domain.entity.article.Article;
import com.aedemirsen.domain.entity.author.Author;
import com.aedemirsen.domain.repository.article.IArticleRepository;
import com.aedemirsen.domain.service.impl.article.ArticleService;
import com.aedemirsen.domain.service.interfaces.author.IAuthorService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.*;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ArticleServiceTest {

    @Mock
    private IArticleRepository articleRepository;
    @Mock
    private IAuthorService authorService;

    @InjectMocks
    private ArticleService articleService;

    private static List<Article> articles;

    @BeforeAll
    static void setUp() {
        articles = Arrays.asList(
                Article.builder().title("Article 1").build(),
                Article.builder().title("Article 2").build(),
                Article.builder().title("Article 3").build()
        );
    }

    @Test
    void save() {
        Author author = Author.builder()
                .username("username")
                .mailAddress("mailAddress")
                .build();

        Article article = Article.builder()
                .authorUsername(author.getUsername())
                .title("title")
                .body("body")
                .build();

        when(authorService.findByUsername(author.getUsername())).thenReturn(author);
        when(articleRepository.save(article)).thenReturn(article);

        var a = articleService.save(article);

        ArgumentCaptor<Article> articleArgumentCaptor = ArgumentCaptor.forClass(Article.class);
        verify(articleRepository).save(articleArgumentCaptor.capture());

        assertThat(a).isNotNull();
        assertThat(articleArgumentCaptor.getValue()).isEqualTo(a);

        verify(authorService).findByUsername(author.getUsername());
    }

    @Test
    void shouldFindAllArticles() {
        when(articleRepository.findAll()).thenReturn(articles);

        List<Article> result = articleService.findAll();

        assertThat(articles.size()).isEqualTo(result.size());
        assertThat(articles).isEqualTo(result);

        verify(articleRepository).findAll();
    }

    @Test
    void shouldFindAllArticlesByPageableArgument() {
        int pageNumber = 0;
        int pageSize = 2;
        int totalElements = articles.size();

        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        Page<Article> page = new PageImpl<>(articles, pageRequest, totalElements);

        when(articleRepository.findAll(pageRequest)).thenReturn(page);

        Page<Article> result = articleService.findAll(pageRequest);

        assertThat(articles.size()).isEqualTo(result.getContent().size());

        assertThat("Article 1").isEqualTo(result.getContent().get(0).getTitle());
        assertThat("Article 2").isEqualTo(result.getContent().get(1).getTitle());
        assertThat("Article 3").isEqualTo(result.getContent().get(2).getTitle());
        assertThat(pageNumber).isEqualTo(result.getNumber());
        assertThat(pageSize).isEqualTo(result.getSize());
        assertThat(totalElements).isEqualTo(result.getTotalElements());

        verify(articleRepository).findAll(pageRequest);
    }

}
