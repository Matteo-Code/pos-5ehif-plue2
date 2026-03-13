package at.spengergasse.domain.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor

@Entity
// @Table(name = "written_exams")
public class WrittenExam extends Exam{
}
