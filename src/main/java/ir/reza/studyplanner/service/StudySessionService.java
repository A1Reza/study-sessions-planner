package ir.reza.studyplanner.service;

import ir.reza.studyplanner.model.StudySession;

import java.util.List;

public interface StudySessionService {

    List<StudySession> findAll();

    StudySession findById(Long id);

    void add(StudySession session);
}