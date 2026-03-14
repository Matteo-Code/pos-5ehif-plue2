package at.spengergasse.domain.fixtures;

import at.spengergasse.domain.domain.Subject;

public class SubjectFixtures {

    public static Subject SUBJECT_1 = Subject
            .builder()
            .id(new Subject.SubjectId(1L))
            .code("POS")
            .name("Programming and Software Engineering")
            .description("Spring Boot")
            .build();


    public static Subject subject() {
        return SUBJECT_1;
    }

}
