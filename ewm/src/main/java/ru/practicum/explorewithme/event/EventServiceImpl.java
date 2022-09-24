package ru.practicum.explorewithme.event;

import org.springframework.stereotype.Service;
import ru.practicum.explorewithme.event.dto.EventFullDto;
import ru.practicum.explorewithme.event.dto.EventShortDto;
import ru.practicum.explorewithme.request.dto.ParticipationRequestDto;

import java.util.List;

@Service
public class EventServiceImpl implements EventService{
    @Override
    public List<EventShortDto> getAllEvents() {
        return null;
    }

    @Override
    public EventFullDto getEvent(long eventId) {
        return null;
    }

    @Override
    public List<EventShortDto> getAllEventsOfUser(long userId) {
        return null;
    }

    @Override
    public EventFullDto updateEventOfUser(long userId, EventFullDto updatingEventDto) {
        return null;
    }

    @Override
    public EventFullDto createEventOfUser(long userId, EventFullDto creatingEventDto) {
        return null;
    }

    @Override
    public EventFullDto getEventOfUser(long userId, long eventId) {
        return null;
    }

    @Override
    public EventFullDto cancelEventOfUser(long userId, long eventId) {
        return null;
    }

    @Override
    public List<ParticipationRequestDto> getRequestsToEventOfUser(long userId, long eventId) {
        return null;
    }

    @Override
    public ParticipationRequestDto confirmRequestToEventOfUser(long userId, long eventId, long reqId) {
        return null;
    }

    @Override
    public ParticipationRequestDto rejectRequestToEventOfUser(long userId, long eventId, long reqId) {
        return null;
    }

    @Override
    public List<EventFullDto> getFullEvents(List<Long> users, List<String> states, List<Long> categories, String rangeStart, String rangeEnd, Integer from, Integer size) {
        return null;
    }

    @Override
    public EventFullDto editEvent(long eventId, EventFullDto editingEvent) {
        return null;
    }

    @Override
    public EventFullDto publishEvent(long eventId) {
        return null;
    }

    @Override
    public EventFullDto rejectEvent(long eventId) {
        return null;
    }
}
