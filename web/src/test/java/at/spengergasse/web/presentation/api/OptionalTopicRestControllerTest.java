package at.spengergasse.web.presentation.api;

import at.spengergasse.web.commands.CreateOptionalTopicCommand;
import at.spengergasse.web.service.OptionalTopicService;
import at.spengergasse.web.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assumptions.assumeThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(OptionalTopicRestController.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class OptionalTopicRestControllerTest {

    private @MockitoBean OptionalTopicService optionalTopicService;
    private @MockitoBean StudentService studentService;
    private @Autowired MockMvc mockMvc;
    private @Autowired ObjectMapper objectMapper;

    @BeforeEach
    void setup() {
        assumeThat(mockMvc).isNotNull();
    }

    @Test
    void create_optional_subject_returns_ok() throws Exception {
        when(optionalTopicService.createOptionalTopic(any())).thenReturn(TopicFixtures.optionalTopic());

        CreateOptionalTopicCommand command = new CreateOptionalTopicCommand();

        mockMvc.perform(post("api/topics")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(command)))
                .andExpect(status().isOk());
    }

}