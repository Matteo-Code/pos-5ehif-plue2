package at.spengergasse.domain.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@SuperBuilder
@NoArgsConstructor

@Entity
@Table(name = "oral_exams")
public class OralExam extends Exam{

    @NotNull
    private LocalDateTime preparationStart;

}
