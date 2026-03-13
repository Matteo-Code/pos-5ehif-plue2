package at.spengergasse.domain.persistence;

import at.spengergasse.domain.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Student.StudentId> {

}
