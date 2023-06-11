package com.aedemirsen.restapi.service.author;

import com.aedemirsen.domain.entity.author.Author;
import com.aedemirsen.domain.repository.author.IAuthorRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AuthorServiceTest {

    @Mock
    private IAuthorRepository authorRepository;

    private static List<Author> authors;

    @BeforeAll
    static void setUp() {
        authors = Arrays.asList(
                Author.builder().username("user 1").mailAddress("mail 1").build(),
                Author.builder().username("user 2").mailAddress("mail 2").build(),
                Author.builder().username("user 3").mailAddress("mail 3").build()
        );
    }

    @Test
    void shouldFindAuthorByMailAddress() {
        //when(authorRepository.findByMailAddress(authors.get(0).getMailAddress())).thenReturn(Optional.ofNullable(authors.get(0)));
    }

    @Test
    void shouldFindAuthorByUsernameOrMailAddress() {
    }

    @Test
    void shouldFindAuthorByUsername() {
    }

    @Test
    void shouldSaveAuthor() {
    }

    @Test
    void shouldFindAllAuthors() {
    }
}
