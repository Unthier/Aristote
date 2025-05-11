package be.ifapme.sab.db.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import be.ifapme.sab.db.model.CartEntity;

@Repository
public interface CartRepositpry extends ListCrudRepository<CartEntity, Long> {

    
}
