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
@Table(name = "students")
public class Student {

    @EmbeddedId
    private StudentId id;

    @NotNull
    @Column(unique = true)
    private PersonIdentifier studentIdentifier;

    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private LocalDate birthDate;

    @OneToMany(mappedBy = "student")
    private List<Exam> examsTaken;

    @Embeddable
    public record StudentId(@GeneratedValue Long id) {}

}
