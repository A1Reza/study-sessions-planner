package ir.reza.studyplanner.service;

import ir.reza.studyplanner.dto.request.StudySessionRequestDto;
import ir.reza.studyplanner.dto.response.StudySessionResponseDto;

import java.util.List;

public interface StudySessionService {

    List<StudySessionResponseDto> findAll();

    StudySessionResponseDto findById(Long id);

    void add(StudySessionRequestDto dto);
}