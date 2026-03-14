package at.spengergasse.domain.fixtures;

import at.spengergasse.domain.domain.Exam;
import at.spengergasse.domain.domain.FinalExamination;
import at.spengergasse.domain.domain.Student;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.mock;

public class FinalExaminationFixtures {

    public static FinalExamination FINAL_EXAMINATION_1 = FinalExamination
            .builder()
            .id(new FinalExamination.FinalExaminationId(1L))
            .code("FE123")
            .department("HIF")
            .fromDate(LocalDate.of(2026, 1,1))
            .toDate(LocalDate.of(2026, 1,3))
            .exams(List.of(mock(Exam.class),mock(Exam.class)))
            .build();


    public static FinalExamination finalExamination() {
        return FINAL_EXAMINATION_1;
    }

}
