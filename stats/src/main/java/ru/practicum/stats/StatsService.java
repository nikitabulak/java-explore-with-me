package ru.practicum.stats;

import ru.practicum.stats.dto.NewHitDto;
import ru.practicum.stats.dto.StatsDto;

import java.time.LocalDateTime;
import java.util.List;

public interface StatsService {
    void addHit(NewHitDto newHitDto);
    StatsDto getStats(LocalDateTime start, LocalDateTime end, List<String> uris, boolean unique);
}
