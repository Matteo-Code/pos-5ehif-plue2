package at.spengergasse.domain;

import java.util.List;
import java.util.Set;

public record Student(
        Long code,
        String identifier,
        String firstName,
        String lastName,
        // which grade the student is in
        int year,
        List<Grade> grades,
        List<ElectiveSubject> subjects
) {

    public double gradeAverage() {
        return grades.stream()
                .mapToLong(Grade::grade)
                .average()
                .orElse(99);
    }

}
