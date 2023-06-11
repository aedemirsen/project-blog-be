package com.aedemirsen.restapi.mapper.article;

import com.aedemirsen.domain.entity.article.CodeBlock;
import com.aedemirsen.restapi.dto.article.CodeBlockDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ICodeBlockMapper {
    CodeBlock toCodeBlock(CodeBlockDto codeBlockDto);

    CodeBlockDto fromCodeBlock(CodeBlock codeBlock);
}
