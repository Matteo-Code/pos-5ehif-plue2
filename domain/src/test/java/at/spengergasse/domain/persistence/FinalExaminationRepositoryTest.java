package at.spengergasse.domain.persistence;

import at.spengergasse.domain.domain.Exam;
import at.spengergasse.domain.domain.FinalExamination;
import at.spengergasse.domain.fixtures.ExamFixtures;
import at.spengergasse.domain.fixtures.FinalExaminationFixtures;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assumptions.assumeThat;
import static org.mockito.Mockito.mock;

@DataJpaTest
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class FinalExaminationRepositoryTest {

    @Autowired
    FinalExaminationRepository finalExaminationRepository;

    @BeforeEach
    void setup() {
        assumeThat(finalExaminationRepository).isNotNull();
    }

    @Test
    void can_save_exam() {
        var saved = finalExaminationRepository.save(FinalExaminationFixtures.finalExamination());

        assertThat(saved).isNotNull();
        assertThat(saved.getFromDate()).isEqualTo(FinalExaminationFixtures.finalExamination().getFromDate());
    }

    @Test
    void can_save_and_find_exam() {
        var saved = finalExaminationRepository.save(FinalExaminationFixtures.finalExamination());

        var found = finalExaminationRepository.findById(saved.getId());

        assertThat(found.isPresent()).isTrue();
        assertThat(found.get().getId()).isEqualTo(saved.getId());
        assertThat(found.get().getFromDate()).isEqualTo(FinalExaminationFixtures.finalExamination().getFromDate());
    }

}
