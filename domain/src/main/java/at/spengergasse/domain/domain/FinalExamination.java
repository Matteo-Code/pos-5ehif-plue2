package at.spengergasse.domain.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "final_exams")
public class FinalExamination {

    @EmbeddedId
    private FinalExaminationId id;

    @NotNull
    @Column(unique = true)
    private String code;

    @NotNull
    private String department;

    @NotNull
    private LocalDate from;

    @NotNull
    private LocalDate to;

    @Embeddable
    public record FinalExaminationId(@GeneratedValue Long id) {}

}
