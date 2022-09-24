package ru.practicum.explorewithme.event;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.practicum.explorewithme.event.dto.EventFullDto;
import ru.practicum.explorewithme.event.dto.EventShortDto;
import ru.practicum.explorewithme.request.dto.ParticipationRequestDto;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class EventPrivateController {
    private final EventService eventService;

    @GetMapping("/{userId}/events")
    public List<EventShortDto> getAllEventsOfUser(@PathVariable long userId) {
        return eventService.getAllEventsOfUser(userId);
    }

    @PatchMapping("/{userId}/events")
    public EventFullDto updateEventOfUser(@PathVariable long userId, @RequestBody EventFullDto updatingEventDto) {
        return eventService.updateEventOfUser(userId, updatingEventDto);
    }

    @PostMapping("/{userId}/events")
    public EventFullDto createEventOfUser(@PathVariable long userId, @RequestBody EventFullDto creatingEventDto) {
        return eventService.createEventOfUser(userId, creatingEventDto);
    }

    @GetMapping("/{userId}/events/{eventId}")
    public EventFullDto getEventOfUser(@PathVariable long userId, @PathVariable long eventId) {
        return eventService.getEventOfUser(userId, eventId);
    }

    @PatchMapping("/{userId}/events/{eventId}")
    public EventFullDto cancelEventOfUser(@PathVariable long userId, @PathVariable long eventId) {
        return eventService.cancelEventOfUser(userId, eventId);
    }

    @GetMapping("/{userId}/events/{eventId}/requests")
    public List<ParticipationRequestDto> getRequestsToEventOfUser(@PathVariable long userId, @PathVariable long eventId) {
        return eventService.getRequestsToEventOfUser(userId, eventId);
    }

    @PatchMapping("/{userId}/events/{eventId}/requests/{reqId}/confirm")
    public ParticipationRequestDto confirmRequestToEventOfUser(@PathVariable long userId,
                                                               @PathVariable long eventId,
                                                               @PathVariable long reqId) {
        return eventService.confirmRequestToEventOfUser(userId, eventId, reqId);
    }

    @PatchMapping("/{userId}/events/{eventId}/requests/{reqId}/reject")
    public ParticipationRequestDto rejectRequestToEventOfUser(@PathVariable long userId,
                                                               @PathVariable long eventId,
                                                               @PathVariable long reqId) {
        return eventService.rejectRequestToEventOfUser(userId, eventId, reqId);
    }
}
