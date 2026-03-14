package at.spengergasse.domain.fixtures;

import at.spengergasse.domain.domain.PersonIdentifier;
import at.spengergasse.domain.domain.Student;

import java.time.LocalDate;

public class StudentFixtures {

    public static Student STUDENT_1 = Student
            .builder()
            .id(new Student.StudentId(1L))
            .studentIdentifier(new PersonIdentifier("ABC123456"))
            .firstName("Test")
            .lastName("Test")
            .birthDate(LocalDate.of(2006, 12,12))
            .build();


    public static Student student() {
        return STUDENT_1;
    }

}
