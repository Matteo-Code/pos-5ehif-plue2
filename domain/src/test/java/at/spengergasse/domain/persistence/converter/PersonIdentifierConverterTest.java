package at.spengergasse.domain.persistence.converter;

import at.spengergasse.domain.domain.PersonIdentifier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class PersonIdentifierConverterTest {

    PersonIdentifierConverter personIdentifierConverter;

    @BeforeEach
    void setup() {
        personIdentifierConverter = new PersonIdentifierConverter();
    }

    @Test
    void can_convert_to_db_column() {
        assertThat(personIdentifierConverter.convertToDatabaseColumn(null)).isEqualTo(null);
        assertThat(personIdentifierConverter.convertToDatabaseColumn(new PersonIdentifier("ABC123456"))).isEqualTo("ABC123456");
    }

    @Test
    void can_convert_to_entity_attribute() {
        assertThat(personIdentifierConverter.convertToEntityAttribute(null)).isEqualTo(null);
        assertThat(personIdentifierConverter.convertToEntityAttribute("ABC123456")).isEqualTo(new PersonIdentifier("ABC123456"));
    }

    @Test
    void throws_on_invalid_entity_format() {
        assertThatThrownBy(() -> {
            personIdentifierConverter.convertToEntityAttribute("invalid");
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("does not match pattern");
    }

}
