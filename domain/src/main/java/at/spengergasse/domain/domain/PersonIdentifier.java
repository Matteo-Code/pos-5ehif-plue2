package at.spengergasse.domain.domain;

import java.util.regex.Pattern;

public record PersonIdentifier(String identifier) {

    private static final String IDENTIFIER_REGEX = "^[A-Z]{3}[0-9]{6}$";
    private static final Pattern pattern = Pattern.compile(IDENTIFIER_REGEX);

    public PersonIdentifier {
        if(identifier == null) throw new IllegalArgumentException("Identifier cannot be null"); // DQE
        if(!pattern.matcher(identifier).matches()) throw new IllegalArgumentException("Identifier does not match pattern"); // DQE
    }

}
