package at.spengergasse.persistence;

import at.spengergasse.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Teacher.TeacherId> {

}
