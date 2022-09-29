package ru.practicum.stats;

import org.springframework.stereotype.Service;
import ru.practicum.stats.dto.NewHitDto;
import ru.practicum.stats.dto.StatsDto;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StatsServiceImpl implements StatsService{
    @Override
    public void addHit(NewHitDto newHitDto) {

    }

    @Override
    public StatsDto getStats(LocalDateTime start, LocalDateTime end, List<String> uris, boolean unique) {
        return null;
    }
}
