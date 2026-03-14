package at.spengergasse.domain.persistence;

import at.spengergasse.domain.fixtures.StudentFixtures;
import at.spengergasse.domain.fixtures.TeacherFixtures;
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
public class TeacherRepositoryTest {

    @Autowired
    TeacherRepository teacherRepository;

    @BeforeEach
    void setup() {
        assumeThat(teacherRepository).isNotNull();
    }

    @Test
    void can_save_student() {
        var saved = teacherRepository.save(TeacherFixtures.teacher());

        assertThat(saved).isNotNull();
        assertThat(saved.getId()).isEqualTo(TeacherFixtures.teacher().getId());
    }

    @Test
    void can_save_and_find_student() {
        var saved = teacherRepository.saveAndFlush(TeacherFixtures.teacher());

        var found = teacherRepository.findById(saved.getId());

        assertThat(found.isPresent()).isTrue();
        assertThat(found.get().getId()).isEqualTo(saved.getId());
    }

}
