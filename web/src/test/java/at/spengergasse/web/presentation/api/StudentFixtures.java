package at.spengergasse.web.presentation.api;

import at.spengergasse.web.dto.OptionalTopic;
import at.spengergasse.web.dto.Student;

import java.time.LocalDate;

public class StudentFixtures {

    public static Student STUDENT = new Student(1L, "Max", "Mustermann", LocalDate.now());

    public static Student student() {
        return STUDENT;
    }

}
