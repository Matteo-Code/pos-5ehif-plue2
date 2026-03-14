package at.spengergasse;

import at.spengergasse.domain.ElectiveSubject;
import at.spengergasse.domain.Student;

import java.util.List;
import java.util.Map;

public record ElectiveSubjectSummary(
        String name,
        List<Student> students
) {

    public ElectiveSubjectSummary(Map.Entry<ElectiveSubject, List<Student>> entry) {
        this(entry.getKey().name(), entry.getValue());
    }

}
