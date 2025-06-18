package desafio.junior.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record RegistrationDTO(
        @NotNull
        Long codeRegistration,
        @NotBlank
        String course,
        @NotNull
        LocalDate startIn
) {
}
