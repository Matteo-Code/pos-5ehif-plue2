package at.spengergasse.web.presentation.api;

import at.spengergasse.web.commands.CreateOptionalTopicCommand;
import at.spengergasse.web.dto.Enrollment;
import at.spengergasse.web.dto.OptionalTopic;
import at.spengergasse.web.dto.Student;
import at.spengergasse.web.service.OptionalTopicService;
import at.spengergasse.web.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor

@RestController
@RequestMapping("/api/topics")
public class OptionalTopicRestController {

    private final OptionalTopicService optionalTopicService;
    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<OptionalTopic>> getOptionalTopics() {
        return ResponseEntity.ok(optionalTopicService.listAllOptionalTopics());
    }

    @PostMapping
    public ResponseEntity<OptionalTopic> createOptionalTopic(@Valid @RequestBody CreateOptionalTopicCommand command) {
        var created = optionalTopicService.createOptionalTopic(command);
        return ResponseEntity.created(
                URI.create("/api/topics/%d".formatted(created.id()))
        ).body(created);
    }

    @GetMapping("/{id}/students")
    public ResponseEntity<List<Student>> getEnrolledStudents(@PathVariable Long id) {
        return ResponseEntity.ok(optionalTopicService.listEnrolledStudents(id));
    }

    @PatchMapping("/{id}/enroll/{student}")
    public ResponseEntity<Enrollment> enrollStudent2(@PathVariable Long id,
                                                     @PathVariable("student") Long studentId) {
        return optionalTopicService.getOptionalTopicById(id)
                .flatMap(topic -> studentService.getStudentById(studentId)
                        .flatMap(student -> optionalTopicService.enrollStudent(student, topic)))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
