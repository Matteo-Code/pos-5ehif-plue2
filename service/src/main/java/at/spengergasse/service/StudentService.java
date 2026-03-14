package at.spengergasse.service;

import at.spengergasse.ElectiveSubjectSummary;
import at.spengergasse.domain.ElectiveSubject;
import at.spengergasse.domain.Student;
import at.spengergasse.persistence.ElectiveSubjectRepository;
import at.spengergasse.persistence.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final ElectiveSubjectRepository electiveSubjectRepository;

    private final static ElectiveSubject UNASSIGNED_SUBJECT = new ElectiveSubject("Unassigned", Integer.MAX_VALUE);

    public StudentService(StudentRepository studentRepository, ElectiveSubjectRepository electiveSubjectRepository) {
        this.studentRepository = studentRepository;
        this.electiveSubjectRepository = electiveSubjectRepository;
    }

    public List<ElectiveSubjectSummary> assignStudents() {
        Map<ElectiveSubject, List<Student>> electives = constructInitialMap(electiveSubjectRepository.findAll());

        studentRepository
                .findAllByYear(3)
                .stream()
                .sorted(Comparator.comparing(Student::gradeAverage))
                .map(student -> assignToSubject(student, electives))
                .forEach(mappedEntry -> electives.get(mappedEntry.getValue()).add(mappedEntry.getKey()));

        return electives.entrySet()
                .stream()
                .map(ElectiveSubjectSummary::new)
                .sorted(Comparator.comparingInt((ElectiveSubjectSummary subject) -> subject.students().size())
                        .reversed()
                        .thenComparing(ElectiveSubjectSummary::name))
                .toList();
    }

    public Map<ElectiveSubject, List<Student>> constructInitialMap(List<ElectiveSubject> subjects) {
        return Stream.concat(subjects.stream(), Stream.of(UNASSIGNED_SUBJECT))
                .collect(Collectors.toMap(
                        subject -> subject,
                        _ -> new ArrayList<>()
                ));
    }

    public Map.Entry<Student, ElectiveSubject> assignToSubject(Student student, Map<ElectiveSubject, List<Student>> assigned) {
        return Map.entry(student, student.subjects()
                .stream()
                .filter(subject -> assigned.get(subject).size() != subject.numSeats())
                .findFirst()
                .orElse(UNASSIGNED_SUBJECT));
    }
}
