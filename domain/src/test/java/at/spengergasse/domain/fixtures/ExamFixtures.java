package at.spengergasse.domain.fixtures;

import at.spengergasse.domain.domain.Exam;
import at.spengergasse.domain.domain.FinalExamination;
import at.spengergasse.domain.domain.OralExam;
import at.spengergasse.domain.domain.WrittenExam;

import java.time.LocalDateTime;

import static org.mockito.Mockito.mock;

public class ExamFixtures {

    public static Exam EXAM_1 = Exam
            .builder()
            .id(new Exam.ExamId(1L))
            .examStart(LocalDateTime.of(2026, 3, 13, 13, 52))
            .examEnd(LocalDateTime.of(2026, 3, 13, 17, 0))
            .examination(mock(FinalExamination.class))
            .build();

    public static OralExam ORAL_EXAM_1 = OralExam
            .builder()
            .id(new Exam.ExamId(1L))
            .examStart(LocalDateTime.of(2026, 3, 13, 13, 52))
            .examEnd(LocalDateTime.of(2026, 3, 13, 17, 0))
            .preparationStart(LocalDateTime.of(2026, 3,13, 14, 0))
            .build();

    public static WrittenExam WRITTEN_EXAM_1 = WrittenExam
            .builder()
            .id(new Exam.ExamId(1L))
            .examStart(LocalDateTime.of(2026, 3, 13, 13, 52))
            .examEnd(LocalDateTime.of(2026, 3, 13, 17, 0))
            .examination(mock(FinalExamination.class))
            .build();

    public static Exam exam() {
        return EXAM_1;
    }

    public static OralExam oralExam() {
        return ORAL_EXAM_1;
    }

    public static WrittenExam writtenExam() {
        return WRITTEN_EXAM_1;
    }

}
