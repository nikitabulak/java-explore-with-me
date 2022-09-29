package ru.practicum.stats;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.practicum.stats.dto.NewHitDto;
import ru.practicum.stats.dto.StatsDto;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class StatsController {

    private final StatsService statsService;

    @PostMapping("/hit")
    public void addHit(@RequestBody NewHitDto newHitDto) {
        statsService.addHit(newHitDto);
    }

    @GetMapping("/stats")
    public StatsDto getStats(@RequestParam LocalDateTime start,
                             @RequestParam LocalDateTime end,
                             @RequestParam List<String> uris,
                             @RequestParam boolean unique) {
        return statsService.getStats(start, end, uris, unique);
    }
}
