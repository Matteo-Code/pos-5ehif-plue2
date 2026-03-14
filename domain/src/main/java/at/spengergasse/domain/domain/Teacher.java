package at.spengergasse.domain.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "teachers")
public class Teacher {

    @EmbeddedId
    private TeacherId id;

    @NotNull
    @Column(unique = true)
    private PersonIdentifier teacherIdentifier;

    private String firstName;

    @NotNull
    private String lastName;

    @OneToMany(mappedBy = "examiner")
    private List<Exam> examsExamined;

    @OneToMany(mappedBy = "assessor")
    private List<Exam> examsAssessed;

    @Embeddable
    public record TeacherId(@GeneratedValue Long id) {}

}
