package com.aedemirsen.restapi.dto.article;

import com.aedemirsen.restapi.dto.file.FileDto;
import com.aedemirsen.restapi.dto.link.LinkDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
public class ArticleSimpleDto {
    private String author;
    private String title;
    private String body;
    private String category;
    private String group;
    private LocalDateTime createdAt;
    private int readTime;//in minutes
    private FileDto headerImage;
    private Collection<FileDto> images;
    private Collection<LinkDto> embeddedLinks;
}
