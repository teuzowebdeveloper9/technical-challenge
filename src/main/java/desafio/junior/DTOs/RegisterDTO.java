package desafio.junior.DTOs;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record RegisterDTO(
        @NotBlank
        UUID studentId,
        @NotBlank
        UUID RegistrationId
) {
}
