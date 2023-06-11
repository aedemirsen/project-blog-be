package com.aedemirsen.restapi.mapper.file;

import com.aedemirsen.domain.entity.File;
import com.aedemirsen.restapi.dto.file.FileDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IFileMapper {

    FileDto fileToDto(File file);

    File dtoToFile(FileDto fileDto);

}
