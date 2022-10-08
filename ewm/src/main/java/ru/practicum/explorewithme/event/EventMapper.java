package ru.practicum.explorewithme.event;

import ru.practicum.explorewithme.category.CategoryMapper;
import ru.practicum.explorewithme.category.model.Category;
import ru.practicum.explorewithme.event.dto.*;
import ru.practicum.explorewithme.event.model.Event;
import ru.practicum.explorewithme.event.model.State;
import ru.practicum.explorewithme.user.UserMapper;
import ru.practicum.explorewithme.user.model.User;

import java.time.LocalDateTime;

public class EventMapper {
    public static EventFullDto toEventFullDto(Event event, int confirmedRequests, int views) {
        return new EventFullDto(
                event.getId(),
                event.getAnnotation(),
                CategoryMapper.toCategoryDto(event.getCategory()),
                confirmedRequests,
                event.getCreatedOn(),
                event.getDescription(),
                event.getEventDate(),
                UserMapper.toUserShortDto(event.getInitiator()),
                event.getLocation(),
                event.isPaid(),
                event.getParticipantLimit(),
                event.getPublishedOn(),
                event.isRequestModeration(),
                event.getState(),
                event.getTitle(),
                views
        );
    }

    public static EventShortDto toEventShortDto(Event event, int confirmedRequests, int views) {
        return new EventShortDto(
                event.getId(),
                event.getAnnotation(),
                CategoryMapper.toCategoryDto(event.getCategory()),
                confirmedRequests,
                event.getEventDate(),
                UserMapper.toUserShortDto(event.getInitiator()),
                event.isPaid(),
                event.getTitle(),
                views
        );
    }

    public static Event toNewEvent(NewEventDto newEventDto, Category category, LocalDateTime createdOn, User initiator, State state) {
        return new Event(
                0,
                newEventDto.getAnnotation(),
                category,
                createdOn,
                newEventDto.getDescription(),
                newEventDto.getEventDate(),
                initiator,
                newEventDto.getLocation(),
                newEventDto.isPaid(),
                newEventDto.getParticipantLimit(),
                null,
                newEventDto.isRequestModeration(),
                state,
                newEventDto.getTitle()
        );
    }

    public static Event updateEvent(Event event, Category category, UpdateEventRequest updateEventRequest) {
        event.setAnnotation(updateEventRequest.getAnnotation());
        event.setCategory(category);
        event.setDescription(updateEventRequest.getDescription());
        event.setEventDate(updateEventRequest.getEventDate());
        event.setPaid(updateEventRequest.isPaid());
        event.setParticipantLimit(updateEventRequest.getParticipantLimit());
        event.setTitle(updateEventRequest.getTitle());
        return event;
    }

    public static Event updateAdminEvent(Event event, AdminUpdateEventRequest adminUpdateEventRequest, Category category) {
        event.setAnnotation(adminUpdateEventRequest.getAnnotation());
        event.setCategory(category);
        event.setDescription(adminUpdateEventRequest.getDescription());
        event.setEventDate(adminUpdateEventRequest.getEventDate());
        event.setPaid(adminUpdateEventRequest.isPaid());
        event.setParticipantLimit(adminUpdateEventRequest.getParticipantLimit());
        event.setRequestModeration(adminUpdateEventRequest.isRequestModeration());
        event.setTitle(adminUpdateEventRequest.getTitle());
        return event;
    }
}
