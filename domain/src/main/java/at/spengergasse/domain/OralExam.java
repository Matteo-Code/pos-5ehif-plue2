package at.spengergasse.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "oral_exams")
public class OralExam extends Exam{

    @NotNull
    private LocalDateTime preparationStart;

}
