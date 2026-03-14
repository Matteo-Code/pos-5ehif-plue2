package at.spengergasse.service;

import at.spengergasse.ElectiveSubjectSummary;
import at.spengergasse.domain.ElectiveSubject;
import at.spengergasse.domain.Student;
import at.spengergasse.persistence.ElectiveSubjectRepository;
import at.spengergasse.persistence.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

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
        Map<ElectiveSubject, List<Student>> electives = new HashMap<>();


        electives.putAll(
                electiveSubjectRepository
                        .findAll()
                        .stream()
                        .collect(Collectors.toMap(
                        subject -> subject,
                        _ -> new ArrayList<>()
                        ))
        );
        electives.put(UNASSIGNED_SUBJECT, new ArrayList<>());

        studentRepository
                .findAllByYear(3)
                .stream()
                .sorted(Comparator.comparing(Student::gradeAverage))
                .map(student -> assignToSubject(student, electives))
                .forEach(mappedEntry -> electives.get(mappedEntry.getValue()).add(mappedEntry.getKey()));
                /*.forEach(student -> {
                    var subject = assignToSubject(student, electives);
                    if(subject != null) {
                        electives.get(subject).add(student);
                    }
                });*/

        return electives.entrySet()
                .stream()
                .map(ElectiveSubjectSummary::new)
                .sorted(Comparator.comparingInt(subject -> subject.students().size()))
                .toList()
                .reversed();
    }

    /*public ElectiveSubject assignToSubject(Student student, Map<ElectiveSubject, List<Student>> assigned) {
        return student.subjects()
                .stream()
                .filter(subject -> assigned.get(subject).size() != subject.numSeats())
                .findFirst()
                .orElse(null);
    }*/

    public Map.Entry<Student, ElectiveSubject> assignToSubject(Student student, Map<ElectiveSubject, List<Student>> assigned) {
        return Map.entry(student, student.subjects()
                .stream()
                .filter(subject -> assigned.get(subject).size() != subject.numSeats())
                .findFirst()
                .orElse(UNASSIGNED_SUBJECT));
    }
}
