package com.aedemirsen.restapi.dto.author;

import com.aedemirsen.domain.entity.enums.Gender;
import com.aedemirsen.restapi.dto.BaseDto;
import com.aedemirsen.restapi.dto.file.FileDto;
import lombok.*;
import lombok.experimental.SuperBuilder;
import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
public class AuthorDto extends BaseDto {

    private String name;
    private String surname;
    private String username;
    private Gender gender;
    private String mailAddress;
    private AddressDto address;
    private FileDto profilePicture;
    private String title;
    private String about;
    private Collection<SocialMediaDto> socialMedias;

}
