package at.spengergasse.domain.persistence.converter;

import at.spengergasse.domain.domain.PersonIdentifier;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class PersonIdentifierConverter implements AttributeConverter<PersonIdentifier, String> {

    @Override
    public String convertToDatabaseColumn(PersonIdentifier attribute) {
        return attribute != null ? attribute.identifier() : null;
    }

    @Override
    public PersonIdentifier convertToEntityAttribute(String dbData) {
        return dbData != null ? new PersonIdentifier(dbData) : null;
    }
}
