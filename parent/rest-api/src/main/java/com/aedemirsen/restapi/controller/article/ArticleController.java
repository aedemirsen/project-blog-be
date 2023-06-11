package com.aedemirsen.restapi.controller.article;

import com.aedemirsen.core.payload.GenericResponse;
import com.aedemirsen.domain.entity.article.Article;
import com.aedemirsen.domain.service.interfaces.article.IArticleService;
import com.aedemirsen.restapi.dto.article.ArticleDto;
import com.aedemirsen.restapi.mapper.article.IArticleMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import com.aedemirsen.restapi.utils.constants.Apis;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(Apis.Article.BASE_URL)
public class ArticleController {

    private final IArticleMapper articleMapper;
    private final IArticleService articleService;

    //@RolesAllowed({RoleConstants.ROLE_ADMIN})
    @Operation(
            summary = "Inserts a new article to database if it is not already exist. And also checks for author if it is in the db.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Article"),
            responses = {
                    @ApiResponse(description = "Article inserted.", responseCode = "200")
            }
    )
    @PostMapping("/")
    public GenericResponse<ArticleDto> saveArticle(@Valid @RequestBody ArticleDto articleDto) {
        log.error("EKMEK YIYECEKSIN!");
        Article mappedArticle = articleMapper.toArticle(articleDto);
        var insertedArticle = articleService.save(mappedArticle);
        return GenericResponse.<ArticleDto>builder()
                .success(Boolean.TRUE)
                .data(articleMapper.fromArticle(insertedArticle))
                .build();
    }

    @Operation(
            summary = "returns all the articles in the database.",
            responses = {
                    @ApiResponse(description = "Articles", responseCode = "200")
            },
            parameters = {
                    @Parameter(name = "pageable query", in = ParameterIn.PATH, description = "Gets articles by paging rules."),
            }
    )
    @GetMapping("/")
    public List<ArticleDto> getArticles(@ParameterObject Pageable pageable) {
        log.info("EKMEK YIYECEKSIN!");
        return articleService.findAll(pageable).stream().map(articleMapper::fromArticle).collect(Collectors.toList());
    }

}
