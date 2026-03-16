package at.spengergasse.web.presentation.api;

import at.spengergasse.web.dto.OptionalTopic;

public class TopicFixtures {

    public static OptionalTopic OPTIONAL_TOPIC = new OptionalTopic(1L, "BAP", "Business Applications");

    public static OptionalTopic optionalTopic() {
        return OPTIONAL_TOPIC;
    }

}
