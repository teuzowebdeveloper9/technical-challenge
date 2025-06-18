package desafio.junior.DTOs;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public record StudentsDTO(
        @NotBlank
        String name,
        @NotNull
        Integer telephone,
        @NotNull
        @JsonFormat(pattern = "yyyy-MM-dd")
        LocalDate BornIn
) {
}
