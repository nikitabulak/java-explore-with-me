package ru.practicum.explorewithme.request;

import ru.practicum.explorewithme.request.dto.ParticipationRequestDto;

import java.util.List;

public interface RequestService {
    List<ParticipationRequestDto> getRequestsToAnotherEvents(long userId);

    ParticipationRequestDto createRequestToAnotherEvent(long userId, long eventId);

    ParticipationRequestDto cancelRequestToAnotherEvent(long userId, long requestId);


}
