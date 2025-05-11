package be.ifapme.sab.domain.service;

import be.ifapme.sab.api.dto.ArticleDTO;
import be.ifapme.sab.db.repository.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {


    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public ArticleDTO retrieveBy(String id) throws IllegalAccessException {


         return articleRepository.findById(Long.parseLong(id))
                 .map(article -> {
                         return new ArticleDTO(article.getName(), article.getDescription(), article.getPrice(), article.getNumber());
                 }).orElseThrow(() -> new IllegalAccessException("Invalid id"));


    }

    public List<ArticleDTO> retrieveAll() {

         return articleRepository.findAll().stream()
                 .map(article ->
                         new ArticleDTO(article.getName(),
                                 article.getDescription(),
                                 article.getPrice(),
                                 article.getNumber())
                 ).toList();


    }

}
