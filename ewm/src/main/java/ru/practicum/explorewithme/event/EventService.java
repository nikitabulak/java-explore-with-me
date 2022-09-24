package ru.practicum.explorewithme.event;

import ru.practicum.explorewithme.event.dto.EventFullDto;
import ru.practicum.explorewithme.event.dto.EventShortDto;
import ru.practicum.explorewithme.request.dto.ParticipationRequestDto;

import java.util.List;

public interface EventService {
    //Public___________________________________________________
    List<EventShortDto> getAllEvents();

    EventFullDto getEvent(long eventId);

    //Private___________________________________________________
    List<EventShortDto> getAllEventsOfUser(long userId);

    EventFullDto updateEventOfUser(long userId, EventFullDto updatingEventDto);

    EventFullDto createEventOfUser(long userId, EventFullDto creatingEventDto);

    EventFullDto getEventOfUser(long userId, long eventId);

    EventFullDto cancelEventOfUser(long userId, long eventId);

    List<ParticipationRequestDto> getRequestsToEventOfUser(long userId, long eventId);

    ParticipationRequestDto confirmRequestToEventOfUser(long userId, long eventId, long reqId);
    ParticipationRequestDto rejectRequestToEventOfUser(long userId, long eventId, long reqId);

    //Admin___________________________________________________
    List<EventFullDto> getFullEvents(List<Long> users,
                                     List<String> states,
                                     List<Long> categories,
                                     String rangeStart,
                                     String rangeEnd,
                                     Integer from,
                                     Integer size);

    EventFullDto editEvent(long eventId, EventFullDto editingEvent);
    EventFullDto publishEvent(long eventId);
    EventFullDto rejectEvent(long eventId);
}
