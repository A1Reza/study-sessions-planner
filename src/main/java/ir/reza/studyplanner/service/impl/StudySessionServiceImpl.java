package ir.reza.studyplanner.service.impl;

import ir.reza.studyplanner.dto.request.StudySessionRequestDto;
import ir.reza.studyplanner.dto.response.StudySessionResponseDto;
import ir.reza.studyplanner.mapper.StudySessionMapper;
import ir.reza.studyplanner.model.StudySession;
import ir.reza.studyplanner.model.Subject;
import ir.reza.studyplanner.repository.StudySessionRepository;
import ir.reza.studyplanner.repository.SubjectRepository;
import ir.reza.studyplanner.service.StudySessionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudySessionServiceImpl implements StudySessionService {

    private final StudySessionRepository studySessionRepository;
    private final StudySessionMapper studySessionMapper;
    private final SubjectRepository subjectRepository;

    public StudySessionServiceImpl(
            StudySessionRepository studySessionRepository,
            SubjectRepository subjectRepository,
            StudySessionMapper studySessionMapper) {

        this.studySessionRepository = studySessionRepository;
        this.subjectRepository = subjectRepository;
        this.studySessionMapper = studySessionMapper;
    }

    @Override
    public List<StudySessionResponseDto> findAll() {
        return studySessionRepository.findAll()
                .stream()
                .map(studySessionMapper::toResponseDto)
                .toList();
    }

    @Override
    public StudySessionResponseDto findById(Long id) {
        StudySession session = studySessionRepository.findById(id);

        if (session == null) {
            return null;
        }

        return studySessionMapper.toResponseDto(session);
    }

    @Override
    public void add(StudySessionRequestDto dto) {

        Subject subject = subjectRepository.findById(dto.subjectId());

        if (subject == null) {
            throw new IllegalArgumentException("Selected subject does not exist");
        }

        StudySession session = studySessionMapper.toEntity(dto);

        studySessionRepository.add(session);
    }
}