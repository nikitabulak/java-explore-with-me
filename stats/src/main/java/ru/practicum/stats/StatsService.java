package ru.practicum.stats;

import ru.practicum.stats.dto.EndpointHit;
import ru.practicum.stats.dto.HitDto;
import ru.practicum.stats.dto.StatsDto;

import java.time.LocalDateTime;
import java.util.List;

public interface StatsService {
    HitDto addHit(EndpointHit newHitDto);
    List<StatsDto> getStats(LocalDateTime start, LocalDateTime end, List<String> uris, boolean unique);
}
