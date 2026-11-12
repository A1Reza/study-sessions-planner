package ir.reza.studyplanner.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record StudySessionRequestDto(

        @NotNull(message = "Please select a subject")
        Long subjectId,

        @Min(value = 1, message = "Duration must be at least 1 minute")
        int minutes,

        @NotBlank(message = "Notes cannot be empty")
        @Size(max = 255, message = "Notes cannot exceed 255 characters")
        String notes

) {
}