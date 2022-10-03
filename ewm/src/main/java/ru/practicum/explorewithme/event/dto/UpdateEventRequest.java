package ru.practicum.explorewithme.event.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.practicum.explorewithme.category.dto.CategoryDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateEventRequest {
    private long eventId;
    @NotNull
    @NotBlank
    @Size(min = 20, max = 2000)
    private String annotation;
    private long category;
    @NotNull
    @NotBlank
    @Size(min = 20, max = 7000)
    private String description;
    @NotNull
    private LocalDateTime eventDate;
    private boolean paid;
    private int participantLimit;
    @NotNull
    @NotBlank
    @Size(min = 3, max = 120)
    private String title;
}
