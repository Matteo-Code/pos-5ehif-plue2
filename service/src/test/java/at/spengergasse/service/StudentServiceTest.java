package at.spengergasse.service;

import at.spengergasse.ElectiveSubjectSummary;
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
    }

}
