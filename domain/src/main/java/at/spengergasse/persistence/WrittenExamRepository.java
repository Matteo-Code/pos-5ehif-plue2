package at.spengergasse.persistence;

import at.spengergasse.domain.Exam;
import at.spengergasse.domain.WrittenExam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WrittenExamRepository extends JpaRepository<WrittenExam, Exam.ExamId> {

    Optional<WrittenExam> findById(Exam.ExamId id);

}
