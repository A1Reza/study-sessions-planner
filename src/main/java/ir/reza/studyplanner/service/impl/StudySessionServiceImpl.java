package ir.reza.studyplanner.service.impl;

import ir.reza.studyplanner.model.StudySession;
import ir.reza.studyplanner.repository.StudySessionRepository;
import ir.reza.studyplanner.service.StudySessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudySessionServiceImpl implements StudySessionService {

    private final StudySessionRepository studySessionRepository;

    @Autowired
    public StudySessionServiceImpl(
            StudySessionRepository studySessionRepository) {
        this.studySessionRepository = studySessionRepository;
    }

    @Override
    public List<StudySession> findAll() {
        return studySessionRepository.findAll();
    }

    @Override
    public StudySession findById(Long id) {
        return studySessionRepository.findById(id);
    }

    @Override
    public void add(StudySession session) {
        studySessionRepository.add(session);
    }
}