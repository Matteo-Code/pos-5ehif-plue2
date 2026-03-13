package at.spengergasse.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "students")
public class Student {

    @EmbeddedId
    private StudentId id;

    @NotNull
    @Column(unique = true)
    private String studentIdentifier;

    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private LocalDate birthDate;

    @Embeddable
    public record StudentId(@Id @GeneratedValue Long value) {}

}
