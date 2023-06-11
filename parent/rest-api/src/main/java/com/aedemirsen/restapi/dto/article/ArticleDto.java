package com.aedemirsen.restapi.dto.article;

import com.aedemirsen.restapi.dto.BaseDto;
import com.aedemirsen.restapi.dto.file.FileDto;
import com.aedemirsen.restapi.dto.link.LinkDto;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
public class ArticleDto extends BaseDto {
    private String authorUsername;
    private String title;
    private String body;
    private String category;
    private String group;
    private Collection<TagDto> tags;
    private Collection<CodeBlockDto> codeBlocks;
    private int readTime;//in minutes
    private FileDto headerImage;
    private Collection<FileDto> images;
    private Collection<LinkDto> embeddedLinks;
}
