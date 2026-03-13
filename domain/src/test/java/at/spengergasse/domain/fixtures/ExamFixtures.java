package at.spengergasse.domain.fixtures;

import at.spengergasse.domain.domain.Exam;

import java.time.LocalDateTime;

public class ExamFixtures {

    public static Exam EXAM_1 = Exam
            .builder()
            .id(new Exam.ExamId(1L))
            .examStart(LocalDateTime.of(2026, 3, 13, 13, 52))
            .examEnd(LocalDateTime.of(2026, 3, 13, 17, 0))
            .build();

    public static Exam exam() {
        return EXAM_1;
    }

}
