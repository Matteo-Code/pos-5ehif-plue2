package at.spengergasse.web.presentation.api;

import at.spengergasse.web.dto.Enrollment;
import at.spengergasse.web.dto.OptionalTopic;
import at.spengergasse.web.dto.Student;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.mockito.Mockito.mock;

public class EnrollmentFixtures {

    public static Enrollment ENROLLMENT = new Enrollment(
            mock(Student.class),
            mock(OptionalTopic.class),
            LocalDateTime.of(2026, 2, 3, 4, 5,6));

    public static Enrollment enrollment() {
        return ENROLLMENT;
    }

}
