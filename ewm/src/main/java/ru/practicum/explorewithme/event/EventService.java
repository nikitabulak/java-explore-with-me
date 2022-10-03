package ru.practicum.explorewithme.event;

import ru.practicum.explorewithme.event.dto.EventFullDto;
import ru.practicum.explorewithme.event.dto.EventShortDto;
import ru.practicum.explorewithme.event.dto.NewEventDto;
import ru.practicum.explorewithme.event.dto.UpdateEventRequest;
import ru.practicum.explorewithme.request.dto.ParticipationRequestDto;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

public interface EventService {
    //Public___________________________________________________
    List<EventShortDto> getAllEvents(String text,
                                     List<Long> categories,
                                     boolean paid,
                                     LocalDateTime rangeStart,
                                     LocalDateTime rangeEnd,
                                     boolean onlyAvailable,
                                     String sort,
                                     int from,
                                     int size);

    EventFullDto getEvent(long eventId, HttpServletRequest httpServletRequest);

    List<EventShortDto> search(String text);


    //Private___________________________________________________
    List<EventShortDto> getAllEventsOfUser(long userId, int from, int size);

    EventFullDto updateEventOfUser(long userId, UpdateEventRequest updateEventRequest);

    EventFullDto createEventOfUser(long userId, NewEventDto newEventDto);

    EventFullDto getEventOfUser(long userId, long eventId);

    EventFullDto cancelEventOfUser(long userId, long eventId);

    List<ParticipationRequestDto> getRequestsForEventOfUser(long userId, long eventId);

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
