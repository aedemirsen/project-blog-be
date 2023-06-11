package com.aedemirsen.restapi.controller;


import com.aedemirsen.core.payload.GenericResponse;
import com.aedemirsen.domain.entity.File;
import com.aedemirsen.domain.entity.enums.config.ConfigurationName;
import com.aedemirsen.domain.service.interfaces.IConfigurationService;
import com.aedemirsen.domain.service.interfaces.IFileService;
import com.aedemirsen.restapi.dto.file.FileDto;
import com.aedemirsen.restapi.mapper.file.IFileMapper;
import com.aedemirsen.restapi.utils.constants.Apis;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(Apis.File.BASE_URL)
public class FileController {

    private final IFileService fileService;
    private final IConfigurationService configurationService;

    private final IFileMapper fileMapper;

    @Operation(
            summary = "Save file",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "file info to save"
            ),
            responses = {
                    @ApiResponse(description = "File saved", responseCode = "200")
            }
    )
    @PostMapping(Apis.File.UPLOAD_FILE)
    public File saveFile(@RequestBody FileDto fileDto) {
        return fileService.save(fileMapper.dtoToFile(fileDto));
    }

    @Operation(
            summary = "Get Secret for File Server",
            responses = {
                    @ApiResponse(description = "Secret", responseCode = "200")
            }
    )
    @GetMapping(Apis.File.FILE_SERVER_SECRET)
    public GenericResponse<String> getSecretForFileServer() {
        var secret = configurationService
                .findCachedValueByName(ConfigurationName.FILE_SERVER_S, null);

        return GenericResponse.<String>builder()
                .success(Boolean.TRUE)
                .message("Success")
                .data(secret)
                .build();
    }
}
