package ir.reza.studyplanner.dto.response;

public record StudySessionResponseDto(
        Long id,
        Long subjectId,
        int minutes,
        String notes
) {
}