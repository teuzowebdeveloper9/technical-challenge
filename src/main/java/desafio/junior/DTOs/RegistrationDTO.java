package desafio.junior.DTOs;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record RegistrationDTO(
        @NotNull
        Long codeRegistration,
        @NotBlank
        String course,
        @NotNull
        @JsonFormat(pattern = "yyyy-MM-dd")
        LocalDate startIn
) {
}
