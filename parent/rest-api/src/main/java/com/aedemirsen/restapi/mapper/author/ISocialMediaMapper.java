package com.aedemirsen.restapi.mapper.author;

import com.aedemirsen.domain.entity.author.SocialMedia;
import com.aedemirsen.restapi.dto.author.SocialMediaDto;
import com.aedemirsen.restapi.mapper.link.ILinkMapper;
import org.mapstruct.Mapper;

@Mapper(uses = ILinkMapper.class,componentModel = "spring")
public interface ISocialMediaMapper {

    SocialMedia toSocialMedia(SocialMediaDto socialMediaDto);

    SocialMediaDto fromSocialMedia(SocialMedia socialMedia);

}
