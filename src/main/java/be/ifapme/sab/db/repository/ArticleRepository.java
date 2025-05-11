package be.ifapme.sab.db.repository;

import be.ifapme.sab.db.model.ArticleEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends ListCrudRepository<ArticleEntity, Long> {

}
