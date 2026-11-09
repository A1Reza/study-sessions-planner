package ir.reza.studyplanner.repository.impl;

import ir.reza.studyplanner.model.StudySession;
import ir.reza.studyplanner.repository.StudySessionRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudySessionRepositoryImpl implements StudySessionRepository {

    private static final List<StudySession> sessions = new ArrayList<>();

    private static Long nextId = 5L;

    static {
        sessions.add(new StudySession(1L, 1L, 60, "Math practice"));
        sessions.add(new StudySession(2L, 1L, 90, "Calculus"));
        sessions.add(new StudySession(3L, 2L, 45, "Physics study"));
        sessions.add(new StudySession(4L, 3L, 120, "Java programming"));
    }

    @Override
    public List<StudySession> findAll() {
        return new ArrayList<>(sessions);
    }

    @Override
    public StudySession findById(Long id) {
        return sessions.stream()
                .filter(session -> session.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void add(StudySession session) {
        session.setId(nextId++);
        sessions.add(session);
    }
}