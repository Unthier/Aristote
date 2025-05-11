package be.ifapme.sab.domain.service;

import be.ifapme.sab.api.dto.UserDTO;
import be.ifapme.sab.db.model.UserEntity;
import be.ifapme.sab.db.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO getUserBy(Long id) {
        return userRepository.findById(id)
                .map(user ->
                        new UserDTO(
                                user.getFirstname(),
                                user.getLastname(),
                                user.getAddress1(), user.getAddress2(), user.getCity(), user.getZipCode())
                ).orElseThrow(() -> new IllegalArgumentException("Invalid id"));
    }

    public void save(UserEntity user){
        userRepository.save(user);
    };
}
