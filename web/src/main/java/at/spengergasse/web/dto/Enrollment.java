package at.spengergasse.web.dto;

import java.time.LocalDateTime;

public record Enrollment(
        Student student,
        OptionalTopic optionalTopic,
        LocalDateTime enrolledAt
) {
}
