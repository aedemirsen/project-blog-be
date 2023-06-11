package com.aedemirsen.restapi.repository.article;

import com.aedemirsen.domain.entity.article.Article;
import com.aedemirsen.domain.repository.article.IArticleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class ArticleRepositoryTest {

    @Autowired
    private IArticleRepository articleRepository;

    @Test
    void findsArticleByTitle() {
        String title = "title";
        Article article = Article.builder()
                .authorUsername("username")
                .title(title)
                .body("body")
                .build();
        articleRepository.save(article);

        Article a = articleRepository.findByTitle(title);

        assertThat(a).isEqualTo(article);

    }

    @Test
    void shouldNotFindArticleByWrongTitle() {
        String title = "title";
        String wrongTitle = "wrong";
        Article article = Article.builder()
                .authorUsername("username")
                .title(title)
                .body("body")
                .build();
        articleRepository.save(article);

        Article a = articleRepository.findByTitle(wrongTitle);

        assertThat(a).isNotEqualTo(article);

    }
}
