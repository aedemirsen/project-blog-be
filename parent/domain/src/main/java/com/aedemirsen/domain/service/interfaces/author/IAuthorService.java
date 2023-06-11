package com.aedemirsen.domain.service.interfaces.author;

import com.aedemirsen.domain.entity.author.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


public interface IAuthorService {

    Author findByMailAddress(String mailAddress);

    Optional<Author> findByUsernameOrMailAddress(String username, String mailAddress);

    Author findByUsername(String username);

    Author save(Author author);

    Page<Author> findAll(Pageable pageable);

}
