package ru.practicum.stats.dto;

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

    public int hitsIncrease() {
        return ++hits;
    }
}
