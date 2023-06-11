package com.aedemirsen.restapi.repository.author;

import com.aedemirsen.domain.entity.author.Author;
import com.aedemirsen.domain.repository.author.IAuthorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class AuthorRepositoryTest {

    @Autowired
    private IAuthorRepository authorRepository;
    private Author author;

    private final String username = "username";
    private final String mailAddress = "mail";

    @BeforeEach
    void setup(){
        author = Author.builder()
                .username(username)
                .mailAddress(mailAddress)
                .build();
        authorRepository.save(author);
    }

    @Test
    void findsArticleByMailAddress() {
        Author a = authorRepository.findByMailAddress(mailAddress).orElse(null);
        assertThat(a).isEqualTo(author);
    }

    @Test
    void findsAuthorByUsernameOrMailAddress() {
        Author a = authorRepository.findByUsernameOrMailAddress(username,mailAddress).orElse(null);
        assertThat(a).isEqualTo(author);
    }

    @Test
    void findsArticleByUsername() {
        Author a = authorRepository.findByUsername(username).orElse(null);
        assertThat(a).isEqualTo(author);
    }
}
