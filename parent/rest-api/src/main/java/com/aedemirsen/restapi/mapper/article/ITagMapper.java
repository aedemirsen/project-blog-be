package com.aedemirsen.restapi.mapper.article;

import com.aedemirsen.domain.entity.article.Tag;
import com.aedemirsen.restapi.dto.article.TagDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ITagMapper {
    Tag toTag(TagDto tagDto);

    TagDto fromTag(Tag tag);
}
