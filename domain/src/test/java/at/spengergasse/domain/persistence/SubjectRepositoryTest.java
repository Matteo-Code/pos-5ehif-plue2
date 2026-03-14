package at.spengergasse.domain.persistence;

import at.spengergasse.domain.fixtures.ExamFixtures;
import at.spengergasse.domain.fixtures.SubjectFixtures;
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
public class SubjectRepositoryTest {

    @Autowired
    SubjectRepository subjectRepository;

    @BeforeEach
    void setup() {
        assumeThat(subjectRepository).isNotNull();
    }

    @Test
    void can_save_exam() {
        var saved = subjectRepository.save(SubjectFixtures.subject());

        assertThat(saved).isNotNull();
        assertThat(saved.getCode()).isEqualTo(SubjectFixtures.subject().getCode());
    }

    @Test
    void can_save_and_find_exam() {
        var saved = subjectRepository.saveAndFlush(SubjectFixtures.subject());

        var found = subjectRepository.findById(saved.getId());

        assertThat(found.isPresent()).isTrue();
        assertThat(found.get().getId()).isEqualTo(saved.getId());
        assertThat(found.get().getCode()).isEqualTo(SubjectFixtures.subject().getCode());
    }

}
