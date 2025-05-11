package be.ifapme.sab.db.repository;

import be.ifapme.sab.db.model.UserEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends ListCrudRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String username);
}
