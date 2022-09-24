package ru.practicum.explorewithme.request;

import ru.practicum.explorewithme.request.dto.ParticipationRequestDto;

import java.util.List;

public interface RequestService {
    List<ParticipationRequestDto> getRequestsToAnotherEvents(long userId);

    ParticipationRequestDto createRequestToAnotherEvent(long userId);
    ParticipationRequestDto cancelRequestToAnotherEvent(long userId, long requestId);

}
