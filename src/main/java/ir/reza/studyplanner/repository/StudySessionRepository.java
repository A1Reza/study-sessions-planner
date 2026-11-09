package ir.reza.studyplanner.repository;

import ir.reza.studyplanner.model.StudySession;

import java.util.List;

public interface StudySessionRepository {

    List<StudySession> findAll();

    StudySession findById(Long id);

    void add(StudySession session);
}