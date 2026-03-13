package at.spengergasse.persistence;

import at.spengergasse.domain.Student;
import at.spengergasse.domain.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Student.StudentId> {

}
