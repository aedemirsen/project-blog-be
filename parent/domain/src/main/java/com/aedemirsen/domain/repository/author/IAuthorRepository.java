package com.aedemirsen.domain.repository.author;

import com.aedemirsen.domain.entity.author.Author;
import com.aedemirsen.domain.repository.base.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAuthorRepository extends BaseRepository<Author,Long> {
    Optional<Author> findByMailAddress(String mailAddress);

    Optional<Author> findByUsernameOrMailAddress(String username,String mailAddress);

    Optional<Author> findByUsername(String username);
}
