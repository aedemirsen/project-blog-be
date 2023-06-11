package com.aedemirsen.domain.entity.author;
import com.aedemirsen.domain.entity.BaseEntity;
import com.aedemirsen.domain.entity.link.Link;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table
public class SocialMedia extends BaseEntity {

    private String name;

    @JoinColumn(name = "link_id")
    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Link link;

}
