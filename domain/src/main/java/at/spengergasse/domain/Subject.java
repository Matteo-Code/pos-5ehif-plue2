package at.spengergasse.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "subjects")
public class Subject {

    @EmbeddedId
    private SubjectId id;

    @NotNull
    @Column(unique = true)
    private String code;

    @NotNull
    private String name;

    private String description;

    @Embeddable
    public record SubjectId(@Id @GeneratedValue Long value) {}

}
