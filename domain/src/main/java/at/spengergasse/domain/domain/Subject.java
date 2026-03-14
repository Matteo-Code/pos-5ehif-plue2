package at.spengergasse.domain.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

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
    public record SubjectId(@GeneratedValue Long id) {}

}
