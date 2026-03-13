package at.spengergasse.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "teachers")
public class Teacher {

    @EmbeddedId
    private TeacherId id;

    @NotNull
    @Column(unique = true)
    private String teacherIdentifier;

    private String firstName;

    @NotNull
    private String lastName;

    @Embeddable
    public record TeacherId(@Id @GeneratedValue Long value) {}

}
