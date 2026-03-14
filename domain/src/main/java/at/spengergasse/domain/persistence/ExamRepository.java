package at.spengergasse.domain.persistence;

import at.spengergasse.domain.domain.Exam;
import at.spengergasse.domain.domain.Student;
import at.spengergasse.domain.domain.Subject;
import at.spengergasse.domain.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Exam.ExamId> {

    Optional<Exam> findById(Exam.ExamId id);

    List<Exam> findByStudent(Student student);

    @Query("select e from Exam e where e.assessor.id = :teacher or e.examiner.id = :teacher")
    List<Exam> findByExaminerAndAssessor(@Param("teacher")Teacher.TeacherId teacher);

    List<Exam> findBySubject(Subject subject);

}
