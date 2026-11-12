package ir.reza.studyplanner.service.impl;

import ir.reza.studyplanner.dto.response.SubjectResponseDto;
import ir.reza.studyplanner.mapper.SubjectMapper;
import ir.reza.studyplanner.model.Subject;
import ir.reza.studyplanner.repository.SubjectRepository;
import ir.reza.studyplanner.service.SubjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;
    private final SubjectMapper subjectMapper;

    public SubjectServiceImpl(
            SubjectRepository subjectRepository,
            SubjectMapper subjectMapper) {

        this.subjectRepository = subjectRepository;
        this.subjectMapper = subjectMapper;
    }

    @Override
    public List<SubjectResponseDto> findAll() {
        return subjectRepository.findAll()
                .stream()
                .map(subjectMapper::toResponseDto)
                .toList();
    }

    @Override
    public SubjectResponseDto findById(Long id) {

        Subject subject = subjectRepository.findById(id);

        if (subject == null) {
            return null;
        }

        return subjectMapper.toResponseDto(subject);
    }
}