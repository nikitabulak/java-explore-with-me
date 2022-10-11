package ru.practicum.explorewithme.event.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StatsDto {
    private String app;
    private String uri;
    private int hits;
}
