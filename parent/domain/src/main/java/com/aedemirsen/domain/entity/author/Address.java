package com.aedemirsen.domain.entity.author;

import lombok.*;

import javax.persistence.Embeddable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class Address{

    private String countryName;
    private String cityName;

}
