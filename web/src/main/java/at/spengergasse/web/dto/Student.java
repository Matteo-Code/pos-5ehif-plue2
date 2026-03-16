package at.spengergasse.web.dto;

import java.time.LocalDate;

public record Student(
        Long id,
        String firstName,
        String lastName,
        LocalDate birthDate
) {
}
