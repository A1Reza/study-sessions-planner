package ir.reza.studyplanner.mapper;

import ir.reza.studyplanner.dto.response.SubjectResponseDto;
import ir.reza.studyplanner.model.Subject;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubjectMapper {

    SubjectResponseDto toResponseDto(Subject subject);
}