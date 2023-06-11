package com.aedemirsen.domain.service.impl;

import com.aedemirsen.domain.entity.File;
import com.aedemirsen.domain.repository.IFileRepository;
import com.aedemirsen.domain.service.interfaces.IFileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class FileService implements IFileService {

    private final IFileRepository fileRepository;

    @Override
    public File save(File file) {
        return fileRepository.save(file);
    }

//    @Override
//    public File findFileByUserUuid(UUID uuid) {
//        return fileRepository.findFileByUserUuid(uuid);
//    }

    @Override
    public void delete(File file) {
        fileRepository.deleteById(file.getId());
    }

    @Override
    public Optional<File> findById(Long id) {
        return fileRepository.findById(id);
    }


}
