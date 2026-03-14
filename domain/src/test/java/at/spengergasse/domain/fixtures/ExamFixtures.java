package at.spengergasse.domain.fixtures;

import at.spengergasse.domain.domain.*;

import java.time.LocalDateTime;

import static org.mockito.Mockito.mock;

public class ExamFixtures {

    public static Exam EXAM_1 = Exam
            .builder()
            .id(new Exam.ExamId(1L))
            .examStart(LocalDateTime.of(2026, 3, 13, 13, 52))
            .examEnd(LocalDateTime.of(2026, 3, 13, 17, 0))
            .examination(mock(FinalExamination.class))
            .student(mock(Student.class))
            .assessor(mock(Teacher.class))
            .examiner(mock(Teacher.class))
            .build();

    public static OralExam ORAL_EXAM_1 = OralExam
            .builder()
            .id(new Exam.ExamId(1L))
            .examStart(LocalDateTime.of(2026, 3, 13, 13, 52))
            .examEnd(LocalDateTime.of(2026, 3, 13, 17, 0))
            .preparationStart(LocalDateTime.of(2026, 3,13, 14, 0))
            .examination(mock(FinalExamination.class))
            .student(mock(Student.class))
            .assessor(mock(Teacher.class))
            .examiner(mock(Teacher.class))
            .build();

    public static WrittenExam WRITTEN_EXAM_1 = WrittenExam
            .builder()
            .id(new Exam.ExamId(1L))
            .examStart(LocalDateTime.of(2026, 3, 13, 13, 52))
            .examEnd(LocalDateTime.of(2026, 3, 13, 17, 0))
            .examination(mock(FinalExamination.class))
            .student(mock(Student.class))
            .assessor(mock(Teacher.class))
            .examiner(mock(Teacher.class))
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
