package at.spengergasse.domain.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "exams")
@Inheritance(strategy = InheritanceType.JOINED)
public class Exam {

    @EmbeddedId
    private ExamId id;

    @NotNull
    private LocalDateTime examStart;

    @NotNull
    private LocalDateTime examEnd;

    @NotNull
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "examination", foreignKey = @ForeignKey(name = "examination__exam__2__final_examination"))
    private FinalExamination examination;

    @NotNull
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "subject", foreignKey = @ForeignKey(name = "subject__exam__2__subject"))
    private Subject subject;

    @NotNull
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "student", foreignKey = @ForeignKey(name = "student__exam__2__student"))
    private Student student;

    @NotNull
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "examiner", foreignKey = @ForeignKey(name = "examiner__exam__2__teacher"))
    private Teacher examiner;

    @NotNull
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "assessor", foreignKey = @ForeignKey(name = "assessor__exam__2__teacher"))
    private Teacher assessor;

    @Embeddable
    public record ExamId(@GeneratedValue Long id) {}

}
