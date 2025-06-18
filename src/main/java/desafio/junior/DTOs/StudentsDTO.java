package desafio.junior.DTOs;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.UniqueElements;

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
