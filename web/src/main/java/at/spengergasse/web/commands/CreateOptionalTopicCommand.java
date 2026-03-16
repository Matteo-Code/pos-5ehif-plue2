package at.spengergasse.web.commands;

import jakarta.validation.constraints.NotNull;

public record CreateOptionalTopicCommand(
        @NotNull String topicIdentifier,
        @NotNull String name
) {
}
