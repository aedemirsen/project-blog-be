package com.aedemirsen.restapi.mapper.author;

import com.aedemirsen.domain.entity.author.Author;
import com.aedemirsen.restapi.dto.author.AuthorDto;
import com.aedemirsen.restapi.mapper.file.IFileMapper;
import org.mapstruct.Mapper;

@Mapper(uses = {ISocialMediaMapper.class, IFileMapper.class},componentModel = "spring")
public interface IAuthorMapper {

    Author toAuthor(AuthorDto authorDto);

    AuthorDto fromAuthor(Author author);
}
