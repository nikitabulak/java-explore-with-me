package ru.practicum.stats;

import org.springframework.stereotype.Service;
import ru.practicum.stats.dto.EndpointHit;
import ru.practicum.stats.dto.StatsDto;
import ru.practicum.stats.model.Hit;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StatsServiceImpl implements StatsService{
    private final HitRepository hitRepository;

    public StatsServiceImpl(HitRepository hitRepository) {
        this.hitRepository = hitRepository;
    }

    @Override
    public void addHit(EndpointHit endpointHit) {
        Hit hit = HitMapper.toNewHit(endpointHit);
        hitRepository.save(hit);
    }

    @Override
    public StatsDto getStats(LocalDateTime start, LocalDateTime end, List<String> uris, boolean unique) {
        List<Hit> hits = hitRepository.getHits(start, end, uris);
        return HitMapper.toStatsDto(hits, unique);
    }
}
