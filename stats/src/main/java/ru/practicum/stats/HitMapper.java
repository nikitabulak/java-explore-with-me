package ru.practicum.stats;

import ru.practicum.stats.dto.EndpointHit;
import ru.practicum.stats.dto.HitDto;
import ru.practicum.stats.dto.StatsDto;
import ru.practicum.stats.model.Hit;

import java.time.LocalDateTime;

public class HitMapper {
    public static HitDto toHitDto(Hit hit) {
        return new HitDto(
                hit.getId(),
                hit.getApp(),
                hit.getUri(),
                hit.getIp(),
                hit.getTimestamp()
        );
    }

    public static Hit toNewHit(EndpointHit endpointHit) {
        return new Hit(
                0,
                endpointHit.getApp(),
                endpointHit.getUri(),
                endpointHit.getIp(),
                LocalDateTime.now()
        );
    }

    public static StatsDto toStatsDto(Hit hit) {
        return new StatsDto(hit.getApp(), hit.getUri(), 1);
    }
}
