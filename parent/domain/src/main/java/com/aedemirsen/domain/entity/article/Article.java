package com.aedemirsen.domain.entity.article;

import com.aedemirsen.domain.entity.File;
import com.aedemirsen.domain.entity.BaseEntity;
import javax.persistence.*;

import com.aedemirsen.domain.entity.link.Link;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table
public class Article extends BaseEntity {

    private String authorUsername;

    @Column(unique = true)
    private String title;

    private String body;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @JoinTable
    @ManyToMany(cascade = CascadeType.ALL)
    private Collection<Tag> tags;

    private String category;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "article_id")
    private Collection<CodeBlock> codeBlocks;

    @Column(name = "group_name")
    private String group;

    private int readTime;//in minutes

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "header_image_id")
    private File headerImage;

    @JoinTable(name = "article_images")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<File> images = new HashSet<>();

    @JoinTable
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<Link> embeddedLinks = new HashSet<>();

}
