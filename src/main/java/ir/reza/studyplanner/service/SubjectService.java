package ir.reza.studyplanner.service;

import ir.reza.studyplanner.dto.response.SubjectResponseDto;

import java.util.List;

public interface SubjectService {

    List<SubjectResponseDto> findAll();

    SubjectResponseDto findById(Long id);
}