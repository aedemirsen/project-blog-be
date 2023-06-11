package com.aedemirsen.restapi.controller.author;

import com.aedemirsen.core.payload.GenericResponse;
import com.aedemirsen.domain.entity.author.Author;
import com.aedemirsen.domain.service.interfaces.author.IAuthorService;
import com.aedemirsen.restapi.dto.author.AuthorDto;
import com.aedemirsen.restapi.mapper.author.IAuthorMapper;
import com.aedemirsen.restapi.utils.constants.Apis;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(Apis.Author.BASE_URL)
public class AuthorController {

    private final IAuthorMapper authorMapper;
    private final IAuthorService authorService;

    @Operation(
            summary = "Inserts a new author to database if it is not already exist.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Author"),
            responses = {
                    @ApiResponse(description = "Author inserted.", responseCode = "200")
            }
    )
    @PostMapping("/")
    public GenericResponse<AuthorDto> saveAuthor(@Valid @RequestBody AuthorDto authorDto){
        Author mappedAuthor = authorMapper.toAuthor(authorDto);
        var insertedAuthor = authorService.save(mappedAuthor);
        return GenericResponse.<AuthorDto>builder()
                .success(Boolean.TRUE)
                .data(authorMapper.fromAuthor(insertedAuthor))
                .message("")
                .build();
    }

    @Operation(
            summary = "returns author who has the specified username.",
            responses = {
                    @ApiResponse(description = "Author", responseCode = "200")
            },
            parameters = {
                    @Parameter(name = "username", in = ParameterIn.PATH, description = "Gets author by given username."),
            }
    )
    @GetMapping("/{username}")
    public AuthorDto getByUsername(@PathVariable("username")  String username){
        return authorMapper.fromAuthor(authorService.findByUsername(username));
    }

}
