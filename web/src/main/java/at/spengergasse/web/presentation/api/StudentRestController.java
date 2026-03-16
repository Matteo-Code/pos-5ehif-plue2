package at.spengergasse.web.presentation.api;

import at.spengergasse.web.commands.CreateStudentCommand;
import at.spengergasse.web.dto.Enrollment;
import at.spengergasse.web.dto.OptionalTopic;
import at.spengergasse.web.dto.Student;
import at.spengergasse.web.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor

@RestController
@RequestMapping("/api/students")
public class StudentRestController {

    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> createOptionalTopic(@Valid @RequestBody CreateStudentCommand command) {
        var created = studentService.createStudent(command);
        return ResponseEntity.created(
                URI.create("/api/students/%d".formatted(created.id())
                )).body(created);
    }

    @GetMapping("/{id}/topics")
    public ResponseEntity<List<OptionalTopic>> getTopics(@PathVariable Long id) {
        return ResponseEntity.ok(
                studentService.getEnrollmentsByStudent(id)
                        .stream()
                        .map(Enrollment::optionalTopic)
                        .toList()
        );
    }

}
