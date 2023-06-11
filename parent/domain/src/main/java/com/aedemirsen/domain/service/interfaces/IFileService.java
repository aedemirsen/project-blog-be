package com.aedemirsen.domain.service.interfaces;

import com.aedemirsen.domain.entity.File;

import java.util.Optional;
import java.util.UUID;

public interface IFileService {

    File save(File file);

 //   File findFileByUserUuid(UUID uuid);

    void delete(File file);

    Optional<File> findById(Long id);

}
