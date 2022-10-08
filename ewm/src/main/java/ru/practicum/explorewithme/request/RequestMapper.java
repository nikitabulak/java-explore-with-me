package ru.practicum.explorewithme.request;

import ru.practicum.explorewithme.event.model.Event;
import ru.practicum.explorewithme.request.dto.ParticipationRequestDto;
import ru.practicum.explorewithme.request.model.Request;
import ru.practicum.explorewithme.user.model.User;

public class RequestMapper {
    public static ParticipationRequestDto toParticipationRequestDto(Request request) {
        return new ParticipationRequestDto(
                request.getId(),
                request.getRequester().getId(),
                request.getEvent().getId(),
                request.getCreated(),
                request.getStatus()
        );
    }

    public static Request toRequest(ParticipationRequestDto participationRequestDto, User user, Event event) {
        return new Request(
                0,
                user,
                event,
                participationRequestDto.getCreated(),
                participationRequestDto.getStatus()
        );
    }
}
