package at.spengergasse.domain.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@SuperBuilder
@Data
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

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "examination", foreignKey = @ForeignKey(name = "examination__exam__2__final_examination"))
    private FinalExamination examination;

    @Embeddable
    public record ExamId(@GeneratedValue Long id) {}

}
