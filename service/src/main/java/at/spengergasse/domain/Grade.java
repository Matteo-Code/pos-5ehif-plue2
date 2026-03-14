package at.spengergasse.domain;

public record Grade(
        String subject,
        // 1 = best; 5 = worst;
        int grade
) {
}
