package ir.reza.studyplanner.repository;

import ir.reza.studyplanner.model.Subject;

import java.util.List;

public interface SubjectRepository {

    List<Subject> findAll();

    Subject findById(Long id);
}
