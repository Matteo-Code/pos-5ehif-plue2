package at.spengergasse.web.service;

import at.spengergasse.web.commands.CreateOptionalTopicCommand;
import at.spengergasse.web.dto.Enrollment;
import at.spengergasse.web.dto.OptionalTopic;
import at.spengergasse.web.dto.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface OptionalTopicService {

    List<OptionalTopic> listAllOptionalTopics();

    Optional<OptionalTopic> getOptionalTopicById(Long id);

    OptionalTopic createOptionalTopic(CreateOptionalTopicCommand command);

    Optional<Enrollment> enrollStudent(Student student, OptionalTopic topic);

    List<Student> listEnrolledStudents(Long id);

}
