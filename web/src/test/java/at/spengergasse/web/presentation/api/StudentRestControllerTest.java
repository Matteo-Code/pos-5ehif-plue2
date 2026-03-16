package at.spengergasse.web.presentation.api;

import at.spengergasse.web.commands.CreateOptionalTopicCommand;
import at.spengergasse.web.commands.CreateStudentCommand;
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

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assumptions.assumeThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(StudentRestController.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StudentRestControllerTest {

    private @MockitoBean StudentService studentService;
    private @Autowired MockMvc mockMvc;
    private @Autowired ObjectMapper objectMapper;

    @BeforeEach
    void setup() {
        assumeThat(studentService).isNotNull();
    }

    @Test
    void create_student_returns_ok() throws Exception{
        when(studentService.createStudent(any())).thenReturn(StudentFixtures.student());

        var command = new CreateStudentCommand("Max", "Mustermann", LocalDate.now());

        mockMvc.perform(post("/api/students")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(command)))
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.firstName").value("Max"))
                .andReturn();
    }

    @Test
    void create_invalid_student_returns_bad_request() throws Exception{
        var command = new CreateStudentCommand("Max", null, LocalDate.now());

        mockMvc.perform(post("/api/students")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(command)))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_PROBLEM_JSON))
                .andReturn();
    }

    @Test
    void list_topics_of_student_returns_ok() throws Exception{
        when(studentService.getEnrollmentsByStudent(anyLong())).thenReturn(List.of(EnrollmentFixtures.enrollment()));

        mockMvc.perform(get("/api/students/1/topics")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(1))
                .andReturn();
    }

}