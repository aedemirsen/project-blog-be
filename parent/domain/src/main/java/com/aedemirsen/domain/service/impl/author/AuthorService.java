package com.aedemirsen.domain.service.impl.author;

import com.aedemirsen.domain.entity.author.Author;
import com.aedemirsen.domain.exception.DuplicateDataException;
import com.aedemirsen.domain.exception.author.AuthorNotFoundException;
import com.aedemirsen.domain.repository.author.IAuthorRepository;
import com.aedemirsen.domain.service.interfaces.author.IAuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


@RequiredArgsConstructor
@Service
public class AuthorService implements IAuthorService {

    private final IAuthorRepository authorRepository;

    @Override
    public Author findByMailAddress(String mailAddress) {
        return authorRepository.findByMailAddress(mailAddress).orElseThrow(AuthorNotFoundException::new);
    }

    @Override
    public Author save(Author author) {
        var existingAuthor = findByUsernameOrMailAddress(author.getUsername(), author.getMailAddress());
        if(existingAuthor.isEmpty()) {
            return authorRepository.save(author);
        }
        throw new DuplicateDataException();
    }

    @Override
    public Author findByUsername(String username) {
        return authorRepository.findByUsername(username).orElseThrow(AuthorNotFoundException::new);
    }

    @Override
    public Optional<Author> findByUsernameOrMailAddress(String username, String mailAddress) {
        return authorRepository.findByUsernameOrMailAddress(username, mailAddress);
    }

    @Override
    public Page<Author> findAll(Pageable pageable) {
        return authorRepository.findAll(pageable);
    }
}
