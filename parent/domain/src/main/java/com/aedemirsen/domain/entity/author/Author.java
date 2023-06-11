package com.aedemirsen.domain.entity.author;

import com.aedemirsen.domain.entity.BaseEntity;
import com.aedemirsen.domain.entity.File;
import com.aedemirsen.domain.entity.enums.Gender;
import lombok.*;

import javax.persistence.*;
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
public class Author extends BaseEntity {

    private String name;

    private String surname;

    @Column(nullable = false, unique = true)
    private String username;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(unique = true)
    private String mailAddress;

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "profile_picture_id")
    private File profilePicture;

    @Embedded
    private Address address;

    private String title;

    private String about;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "author_id")
    private Collection<SocialMedia> socialMedias = new HashSet<>();

    public String getFullName(){
        return this.name.concat(" ").concat(this.surname);
    }


}
