package ir.reza.studyplanner.service;

import ir.reza.studyplanner.model.Subject;

import java.util.List;

public interface SubjectService {

    List<Subject> findAll();

    Subject findById(Long id);
}
