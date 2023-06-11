package com.aedemirsen.restapi.dto.author;

import com.aedemirsen.restapi.dto.link.LinkDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
public class SocialMediaDto {
    private String name;
    private LinkDto link;
}
