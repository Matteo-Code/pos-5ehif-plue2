package at.spengergasse.web.service;

import at.spengergasse.web.commands.CreateStudentCommand;
import at.spengergasse.web.dto.Enrollment;
import at.spengergasse.web.dto.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface StudentService {

    Student createStudent(CreateStudentCommand command);

    Optional<Student> getStudentById(Long id);

    List<Enrollment> getEnrollmentsByStudent(Long id);

}
