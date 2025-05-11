package be.ifapme.sab.domain.service;

import be.ifapme.sab.api.dto.AuthenticationDTO;
import be.ifapme.sab.api.dto.AuthenticationResponseDTO;
import be.ifapme.sab.db.model.UserEntity;
import be.ifapme.sab.db.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;

    public AuthenticationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public ResponseEntity<AuthenticationResponseDTO> login(AuthenticationDTO loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        Optional<UserEntity> optionalUser = userRepository.findByUsername(username);

        if (optionalUser.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new AuthenticationResponseDTO("Utilisateur introuvable", null));
        }


        if (username == null || password == null) {
            return ResponseEntity.badRequest().body(new AuthenticationResponseDTO("Email ou mot de passe manquant", null));
        }


        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new AuthenticationResponseDTO("Identifiants invalides", null));
    }
}
