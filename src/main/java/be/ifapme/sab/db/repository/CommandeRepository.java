package be.ifapme.sab.db.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import be.ifapme.sab.db.model.CommandeEntity;

@Repository
public interface CommandeRepository  extends ListCrudRepository<CommandeEntity, Long>  {

    
}
