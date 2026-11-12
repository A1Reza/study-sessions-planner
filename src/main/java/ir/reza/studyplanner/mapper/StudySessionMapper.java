package ir.reza.studyplanner.mapper;

import ir.reza.studyplanner.dto.request.StudySessionRequestDto;
import ir.reza.studyplanner.dto.response.StudySessionResponseDto;
import ir.reza.studyplanner.model.StudySession;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudySessionMapper {

    @Mapping(target = "id", ignore = true)
    StudySession toEntity(StudySessionRequestDto dto);

    StudySessionResponseDto toResponseDto(StudySession session);
}