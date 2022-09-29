package ru.practicum.stats;

import ru.practicum.stats.dto.NewHitDto;
import ru.practicum.stats.dto.StatsDto;
import ru.practicum.stats.model.Hit;

public class StatsMapper {
    public static StatsDto toStatsDto(Hit hit, int hits) {
        return new StatsDto(
                hit.getApp(),
                hit.getUri(),
                hits
        );
    }

    public static Hit toNewHit(NewHitDto newHitDto) {
        return new Hit(
                0,
                newHitDto.getApp(),
                newHitDto.getUri(),
                newHitDto.getIp(),
                newHitDto.getTimestamp()
        );
    }
}
