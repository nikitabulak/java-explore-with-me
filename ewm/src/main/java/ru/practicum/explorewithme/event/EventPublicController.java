package ru.practicum.explorewithme.event;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.practicum.explorewithme.event.dto.EventFullDto;
import ru.practicum.explorewithme.event.dto.EventShortDto;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/events")
public class EventPublicController {
    private final EventService eventService;

    @GetMapping
    public List<EventShortDto> getAllEvents(@RequestParam String text,
                                            @RequestParam List<Long> categories,
                                            @RequestParam boolean paid,
                                            @RequestParam LocalDateTime rangeStart,
                                            @RequestParam LocalDateTime rangeEnd,
                                            @RequestParam(required = false, defaultValue = "false") boolean onlyAvailable,
                                            @RequestParam String sort,
                                            @RequestParam(required = false, defaultValue = "0") int from,
                                            @RequestParam(required = false, defaultValue = "10") int size) {
        return eventService.getAllEvents(text, categories, paid, rangeStart, rangeEnd, onlyAvailable, sort, from, size);
    }

    @GetMapping("/{eventId}")
    public EventFullDto getEventById(@PathVariable long eventId, HttpServletRequest httpServletRequest) {
        return eventService.getEvent(eventId, httpServletRequest);
    }
}
