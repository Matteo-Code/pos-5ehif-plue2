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
        assertThat(saved.getId()).isEqualTo(ExamFixtures.exam().getId());
    }

    @Test
    void can_save_and_find_exam() {
        var saved = examRepository.saveAndFlush(ExamFixtures.exam());

        var found = examRepository.findById(saved.getId());

        assertThat(found.isPresent()).isTrue();
        assertThat(found.get().getId()).isEqualTo(saved.getId());
        assertThat(found.get().getExamEnd()).isEqualTo(ExamFixtures.exam().getExamEnd());
    }

}
