package at.spengergasse.domain.fixtures;

import at.spengergasse.domain.domain.Student;
import at.spengergasse.domain.domain.Teacher;

import java.time.LocalDate;

public class TeacherFixtures {

    public static Teacher TEACHER_1 = Teacher
            .builder()
            .id(new Teacher.TeacherId(1L))
            .teacherIdentifier("Test123")
            .firstName("Test")
            .lastName("Test")
            .build();


    public static Teacher teacher() {
        return TEACHER_1;
    }

}
