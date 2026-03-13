package at.spengergasse.persistence;

import at.spengergasse.domain.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Exam.ExamId> {

    Optional<Exam> findById(Exam.ExamId id);

}
