package be.ifapme.sab.api.controller;

import be.ifapme.sab.api.dto.AuthenticationDTO;
import be.ifapme.sab.api.dto.AuthenticationResponseDTO;
import be.ifapme.sab.domain.service.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authService) {
        this.authenticationService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponseDTO> login(@RequestBody AuthenticationDTO loginRequest) {
        return authenticationService.login(loginRequest);
    }
}
