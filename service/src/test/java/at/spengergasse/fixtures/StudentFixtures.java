package at.spengergasse.fixtures;

import at.spengergasse.domain.Grade;
import at.spengergasse.domain.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StudentFixtures {

    private static final int TOTAL_GRADES = 3;

    // Everyone has the same choice: 1. BAP, 2. IOT, 3. SOS
    public static List<Student> studentList() {
        return IntStream.rangeClosed(0, 13)
                .mapToObj(i -> new Student((long) i,
                        "Test",
                        "Test",
                        "Test",
                        3,
                        grades(i),
                        ElectiveSubjectFixtures.subjects()))
                .toList();
    }

    public static List<Grade> grades(int number) {
        // Total 10 Grades
        List<Integer> gradesForPerson = new ArrayList<>(Collections.nCopies(TOTAL_GRADES, 1));
        for(int i = 0; i < number; i++) {
            int currentIndex = i % TOTAL_GRADES;
            gradesForPerson.set(currentIndex, gradesForPerson.get(currentIndex) + 1);
        }

        return gradesForPerson.stream()
                .map(grade -> new Grade("Random Subject", grade))
                .toList();
    }

}
