package com.aedemirsen.restapi.mapper.link;

import com.aedemirsen.domain.entity.link.Link;
import com.aedemirsen.restapi.dto.link.LinkDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ILinkMapper {

    Link toLink(LinkDto linkDto);

    LinkDto fromLink(Link link);
}
