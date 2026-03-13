package at.spengergasse.domain.persistence;

import at.spengergasse.domain.domain.FinalExamination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinalExaminationRepository extends JpaRepository<FinalExamination, FinalExamination.FinalExaminationId> {
}
