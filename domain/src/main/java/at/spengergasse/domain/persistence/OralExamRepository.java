package at.spengergasse.domain.persistence;

import at.spengergasse.domain.domain.Exam;
import at.spengergasse.domain.domain.OralExam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OralExamRepository extends JpaRepository<OralExam, Exam.ExamId> {
    Optional<OralExam> findById(Exam.ExamId id);

}
