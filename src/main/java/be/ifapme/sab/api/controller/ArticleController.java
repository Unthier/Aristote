package be.ifapme.sab.api.controller;

import be.ifapme.sab.api.dto.ArticleDTO;
import be.ifapme.sab.domain.service.ArticleService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/article")
public class ArticleController {


    private final ArticleService articleService;

    public ArticleController(final ArticleService articleService) {
        this.articleService = articleService;
    }

    @PreAuthorize("hasAnyRole(RolesEnum.USER)")
    @GetMapping(value ="/{id}", produces = "application/json")
    public ArticleDTO getArticle(@PathVariable String id) throws IllegalAccessException {
        if (id == null || id.isEmpty() || id.trim().isEmpty()) {
            throw new IllegalAccessException("No id provided");
        }
        if (!id.matches("\\d+")) {
            throw new IllegalAccessException("Invalid id");
        }


        return articleService.retrieveBy(id);
    }


    @GetMapping(value ="/all", produces = "application/json")
    public List<ArticleDTO> getAllArticles() throws IllegalAccessException {
        return articleService.retrieveAll();
    }

    @PreAuthorize("hasAnyRole(RolesEnum.USER)")
    @GetMapping(value ="/addtocart/{id}", produces = "application/json")
    public void addToCart(@PathVariable String id) throws IllegalAccessException {
        if (id == null || id.isEmpty() || id.trim().isEmpty()) {
            throw new IllegalAccessException("No id provided");
        }
        if (!id.matches("\\d+")) {
            throw new IllegalAccessException("Invalid id");
        }

        ArticleDTO article = articleService.retrieveBy(id);

    }

    @PreAuthorize("hasAnyRole(RolesEnum.USER)")
    @GetMapping(value ="/{category}", produces = "application/json")
    public List<ArticleDTO> getAllArticlesByCategory(@PathVariable String category) throws IllegalAccessException {
        if (category == null || category.isEmpty() || category.trim().isEmpty()) {
            throw new IllegalAccessException("No category provcategoryed");
        }
        if (!category.matches("\\d+")) {
            throw new IllegalAccessException("Invalid category");
        }

        return articleService.retrieveAll().stream()
            .filter(article -> String.valueOf(article.getCategory()).equals(category))
            .collect(Collectors.toList());

    }


}
