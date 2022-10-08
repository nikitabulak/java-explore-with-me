package ru.practicum.stats;

import org.springframework.stereotype.Service;
import ru.practicum.stats.dto.EndpointHit;
import ru.practicum.stats.dto.HitDto;
import ru.practicum.stats.dto.StatsDto;
import ru.practicum.stats.model.Hit;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StatsServiceImpl implements StatsService {
    private final HitRepository hitRepository;

    public StatsServiceImpl(HitRepository hitRepository) {
        this.hitRepository = hitRepository;
    }

    @Override
    public HitDto addHit(EndpointHit endpointHit) {
        Hit hit = HitMapper.toNewHit(endpointHit);
        hit = hitRepository.save(hit);
        return HitMapper.toHitDto(hit);
    }

    @Override
    public List<StatsDto> getStats(LocalDateTime start, LocalDateTime end, List<String> uris, boolean unique) {
        List<Hit> hits = hitRepository.getHits(start, end, uris);
        if (hits.isEmpty()) {
            return List.of(new StatsDto(null, null, 0));
        }
        if (!unique) {
            Map<String, StatsDto> statsMap = new HashMap<>();
            for (Hit hit : hits) {
                String uri = hit.getUri();
                if (!statsMap.containsKey(uri)) {
                    statsMap.put(uri, HitMapper.toStatsDto(hit));
                } else {
                    statsMap.get(uri).hitsIncrease();
                }
            }
            return new ArrayList<>(statsMap.values());
        } else {
            Map<String, Map<String, StatsDto>> statsMap = new HashMap<>();
            for (Hit hit : hits) {
                String ip = hit.getIp();
                String uri = hit.getUri();
                if (!statsMap.containsKey(uri)) {
                    Map<String, StatsDto> innerMap = new HashMap<>();
                    innerMap.put(ip, HitMapper.toStatsDto(hit));
                    statsMap.put(uri, innerMap);
                } else {
                    if (!statsMap.get(uri).containsKey(ip)) {
                        statsMap.get(uri).put(ip, HitMapper.toStatsDto(hit));
                    }
                }
            }
            List<StatsDto> statsDtos = new ArrayList<>();
            for (String string : statsMap.keySet()) {
                List<StatsDto> stats = new ArrayList<>(statsMap.get(string).values());
                statsDtos.add(new StatsDto(stats.get(0).getApp(), stats.get(0).getUri(), stats.size()));
            }
            return statsDtos;
        }
    }
}
