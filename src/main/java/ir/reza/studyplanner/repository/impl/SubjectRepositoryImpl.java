package ir.reza.studyplanner.repository.impl;

import ir.reza.studyplanner.model.Subject;
import ir.reza.studyplanner.repository.SubjectRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SubjectRepositoryImpl implements SubjectRepository {

    private static final List<Subject> subjects = new ArrayList<>();

    static { //This section is executed only once when the class is loaded.
        subjects.add(new Subject(1L, "MATH"));
        subjects.add(new Subject(2L, "PHYSICS"));
        subjects.add(new Subject(3L, "CS"));
    }

    @Override
    public List<Subject> findAll() {
        return new ArrayList<>(subjects);
    }

    @Override
    public Subject findById(Long id) {
        return subjects.stream()
                .filter(subject -> subject.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}