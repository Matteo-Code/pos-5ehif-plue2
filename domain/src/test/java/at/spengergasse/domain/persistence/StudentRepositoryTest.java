package at.spengergasse.domain.persistence;

import at.spengergasse.domain.fixtures.StudentFixtures;
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
public class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;

    @BeforeEach
    void setup() {
        assumeThat(studentRepository).isNotNull();
    }

    @Test
    void can_save_student() {
        var saved = studentRepository.save(StudentFixtures.student());

        assertThat(saved).isNotNull();
        assertThat(saved.getId()).isEqualTo(StudentFixtures.student().getId());
    }

    @Test
    void can_save_and_find_student() {
        var saved = studentRepository.saveAndFlush(StudentFixtures.student());

        var found = studentRepository.findById(saved.getId());

        assertThat(found.isPresent()).isTrue();
        assertThat(found.get().getId()).isEqualTo(saved.getId());
        assertThat(found.get().getBirthDate()).isEqualTo(StudentFixtures.student().getBirthDate());
    }

}
