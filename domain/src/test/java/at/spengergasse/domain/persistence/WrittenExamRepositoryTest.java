package at.spengergasse.domain.persistence;

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
public class WrittenExamRepositoryTest {

    @Autowired
    WrittenExamRepository writtenExamRepository;

    @BeforeEach
    void setup() {
        assumeThat(writtenExamRepository).isNotNull();
    }

    @Test
    void can_save_exam() {
        var saved = writtenExamRepository.save(ExamFixtures.writtenExam());

        assertThat(saved).isNotNull();
        assertThat(saved.getExamStart()).isEqualTo(ExamFixtures.writtenExam().getExamStart());
    }

    @Test
    void can_save_and_find_exam() {
        var saved = writtenExamRepository.save(ExamFixtures.writtenExam());
        var found = writtenExamRepository.findById(saved.getId());

        assertThat(found.isPresent()).isTrue();
        assertThat(found.get().getId()).isEqualTo(saved.getId());
        assertThat(found.get().getExamEnd()).isEqualTo(ExamFixtures.writtenExam().getExamEnd());
    }

}
