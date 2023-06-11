package com.aedemirsen.domain.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
@ToString
@Table
public class File extends BaseEntity{
    /**
     * UUID of the uploaded file given by the file server
     */
    @Column(name = "UUID")
    private String uuid;

    /**
     * File name of the uploaded file
     */
    private String fileName;

    private String mimeType;

    private String description;

    private double fileSize;

    private Integer width;

    private Integer height;

    @Column(name = "is_deleted")
    private boolean deleted;
}
