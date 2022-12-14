package ru.practicum.stats;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import ru.practicum.stats.dto.EndpointHit;
import ru.practicum.stats.dto.HitDto;
import ru.practicum.stats.dto.StatsDto;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class StatsController {

    private final StatsService statsService;

    @PostMapping("/hit")
    public HitDto addHit(@RequestBody EndpointHit newHitDto) {
        return statsService.addHit(newHitDto);
    }

    @GetMapping("/stats")
    public List<StatsDto> getStats(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime start,
                             @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime end,
                             @RequestParam List<String> uris,
                             @RequestParam boolean unique) {
        return statsService.getStats(start, end, uris, unique);
    }
}
