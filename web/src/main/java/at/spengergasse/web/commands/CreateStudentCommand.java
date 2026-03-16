package at.spengergasse.web.commands;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CreateStudentCommand(
        @NotNull String firstName,
        @NotNull String lastName,
        @NotNull LocalDate birthDate) {
}
