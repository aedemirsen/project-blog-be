package com.aedemirsen.restapi.mapper.article;

import com.aedemirsen.domain.entity.article.Article;
import com.aedemirsen.restapi.dto.article.ArticleDto;
import com.aedemirsen.restapi.mapper.file.IFileMapper;
import com.aedemirsen.restapi.mapper.link.ILinkMapper;
import org.mapstruct.Mapper;


@Mapper(uses = {
        IFileMapper.class,
        ITagMapper.class,
        ILinkMapper.class,
        ICodeBlockMapper.class},
        componentModel = "spring")
public interface IArticleMapper {

    Article toArticle(ArticleDto articleDto);

    ArticleDto fromArticle(Article article);

}
