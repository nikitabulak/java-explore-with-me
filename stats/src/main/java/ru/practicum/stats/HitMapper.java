package ru.practicum.stats;

import ru.practicum.stats.dto.EndpointHit;
import ru.practicum.stats.dto.HitDto;
import ru.practicum.stats.dto.StatsDto;
import ru.practicum.stats.model.Hit;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
    public static StatsDto toStatsDto(List<Hit> hits, boolean unique) {
        if (!hits.isEmpty()) {
            if (!unique) {
                return new StatsDto(hits.get(0).getApp(), hits.get(0).getUri(), hits.size());
            } else {
                List<String> ips = new ArrayList<>();
                int uniqueHits = 0;
                for (Hit hit : hits) {
                    if (!ips.contains(hit.getIp())) {
                        ips.add(hit.getIp());
                        uniqueHits++;
                    }
                }
                return new StatsDto(hits.get(0).getApp(), hits.get(0).getUri(), uniqueHits);
            }
        } else {
            return new StatsDto(null, null, 0);
        }
    }
}
