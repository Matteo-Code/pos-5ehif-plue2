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
    public record TeacherId(@GeneratedValue Long id) {}

}
