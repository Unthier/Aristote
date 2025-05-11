package be.ifapme.sab.api.dto;

public class AuthenticationResponseDTO {
        private String message;
        private String token;

        public AuthenticationResponseDTO(String message, String token) {
            this.message = message;
            this.token = token;
        }
}
