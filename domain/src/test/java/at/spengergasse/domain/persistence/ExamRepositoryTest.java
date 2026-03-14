package at.spengergasse.domain.persistence;

import at.spengergasse.domain.domain.Exam;
import at.spengergasse.domain.fixtures.ExamFixtures;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assumptions.assumeThat;

@DataJpaTest
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class ExamRepositoryTest {

    @Autowired
    ExamRepository examRepository;

    @BeforeEach
    void setup() {
        assumeThat(examRepository).isNotNull();
    }

    @Test
    void can_save_exam() {
        var saved = examRepository.save(ExamFixtures.exam());

        assertThat(saved).isNotNull();
        assertThat(saved.getExamStart()).isEqualTo(ExamFixtures.exam().getExamStart());
    }

    @Test
    void can_save_and_find_exam() {
        var saved = examRepository.save(ExamFixtures.exam());
        var found = examRepository.findById(saved.getId());

        assertThat(found.isPresent()).isTrue();
        assertThat(found.get().getId()).isEqualTo(saved.getId());
        assertThat(found.get().getExamEnd()).isEqualTo(ExamFixtures.exam().getExamEnd());
    }

    @Test
    void can_find_by_student() {
        var saved = examRepository.save(ExamFixtures.exam2());
        var found = examRepository.findByStudent(saved.getStudent());

        assertThat(found.size()).isEqualTo(1);
        assertThat(found)
                .extracting(Exam::getStudent)
                .containsOnly(saved.getStudent());
        assertThat(found.getFirst().getExamStart()).isEqualTo(ExamFixtures.exam2().getExamStart());
    }

    @Test
    void can_find_by_teacher() {
        var saved = examRepository.save(ExamFixtures.exam2());
        var found = examRepository.findByExaminerAndAssessor(saved.getExaminer().getId());

        assertThat(found.size()).isEqualTo(1);
        assertThat(found)
                .extracting(Exam::getExaminer)
                .containsOnly(saved.getExaminer());
        assertThat(found.getFirst().getExamStart()).isEqualTo(ExamFixtures.exam2().getExamStart());
    }

    @Test
    void can_find_by_subject() {
        var saved = examRepository.save(ExamFixtures.exam2());
        var found = examRepository.findBySubject(saved.getSubject());

        assertThat(found.size()).isEqualTo(1);
        assertThat(found)
                .extracting(Exam::getSubject)
                .containsOnly(saved.getSubject());
        assertThat(found.getFirst().getExamStart()).isEqualTo(ExamFixtures.exam2().getExamStart());
    }
}
