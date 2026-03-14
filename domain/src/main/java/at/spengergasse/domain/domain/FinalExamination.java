package at.spengergasse.domain.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "final_exams")
public class FinalExamination {

    @EmbeddedId
    private FinalExaminationId id;

    @NotNull
    @Column(unique = true, name = "final_exam_code")
    private String code;

    @NotNull
    private String department;

    @NotNull
    private LocalDate fromDate;

    @NotNull
    private LocalDate toDate;

    @OneToMany(mappedBy = "examination")
    private List<Exam> exams;

    @Embeddable
    public record FinalExaminationId(@GeneratedValue Long id) {}

}
