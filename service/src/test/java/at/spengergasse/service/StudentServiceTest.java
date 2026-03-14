package at.spengergasse.service;

import at.spengergasse.ElectiveSubjectSummary;
import at.spengergasse.domain.ElectiveSubject;
import at.spengergasse.domain.Student;
import at.spengergasse.fixtures.ElectiveSubjectFixtures;
import at.spengergasse.fixtures.StudentFixtures;
import at.spengergasse.persistence.ElectiveSubjectRepository;
import at.spengergasse.persistence.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assumptions.assumeThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class StudentServiceTest {

    @Mock
    StudentRepository studentRepository;

    @Mock
    ElectiveSubjectRepository electiveSubjectRepository;

    @InjectMocks
    StudentService studentService;

    @BeforeEach
    void setup() {
        assumeThat(studentRepository).isNotNull();
        assumeThat(electiveSubjectRepository).isNotNull();
    }

    @Test
    void can_assign_elective_subject_correctly() {
        when(electiveSubjectRepository.findAll()).thenReturn(ElectiveSubjectFixtures.subjects());
        when(studentRepository.findAllByYear(anyInt())).thenReturn(
                StudentFixtures.studentList()
        );

        List<ElectiveSubjectSummary> summary = studentService.assignStudents();

        assertThat(summary.size()).isEqualTo(4);
        assertThat(summary.getFirst().students().size()).isEqualTo(5); // BAP
        assertThat(summary.get(1).students().size()).isEqualTo(5); // IOT
        assertThat(summary.get(2).students().size()).isEqualTo(3); // SOS
        assertThat(summary.get(3).students().size()).isEqualTo(1); // UNASSIGNED

        assertThat(summary.getFirst().students().getFirst().gradeAverage()).isEqualTo(StudentFixtures.studentList().getFirst().gradeAverage());
    }

    @Test
    void correctly_maps_to_priority_subject() {
        Map<ElectiveSubject, List<Student>> assigned = Map.of(ElectiveSubjectFixtures.bap(), List.of());
        Map.Entry<Student, ElectiveSubject> mappedResult = studentService.assignToSubject(StudentFixtures.studentList().getFirst(),
                assigned
        );

        assertThat(mappedResult.getKey()).isEqualTo(StudentFixtures.studentList().getFirst());
        assertThat(mappedResult.getValue()).isEqualTo(ElectiveSubjectFixtures.bap());
    }

    @Test
    void correctly_maps_if_subject_is_full() {
        Map<ElectiveSubject, List<Student>> assigned = Map.of(ElectiveSubjectFixtures.bap(),
                StudentFixtures.studentList().subList(0, 5),
                ElectiveSubjectFixtures.iot(),
                List.of());
        Map.Entry<Student, ElectiveSubject> mappedResult = studentService.assignToSubject(StudentFixtures.studentList().getFirst(),
                assigned
        );

        assertThat(mappedResult.getKey()).isEqualTo(StudentFixtures.studentList().getFirst());
        assertThat(mappedResult.getValue()).isEqualTo(ElectiveSubjectFixtures.iot());
    }

}
