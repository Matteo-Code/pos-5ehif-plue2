package at.spengergasse.persistence;

import at.spengergasse.domain.ElectiveSubject;
import at.spengergasse.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ElectiveSubjectRepository {

    List<ElectiveSubject> findAll();

}
