package at.spengergasse.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "exams")
public class Exam {

    @EmbeddedId
    private ExamId id;

    @NotNull
    private LocalDateTime examStart;

    @NotNull
    private LocalDateTime examEnd;

    @Embeddable
    public record ExamId(@Id @GeneratedValue Long value) {}

}
