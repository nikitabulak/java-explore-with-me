package ru.practicum.explorewithme.request.model;

import org.springframework.stereotype.Service;
import ru.practicum.explorewithme.request.RequestService;
import ru.practicum.explorewithme.request.dto.ParticipationRequestDto;

import java.util.List;

@Service
public class RequestServiceImpl implements RequestService {
    //Private___________________________________________________
    @Override
    public List<ParticipationRequestDto> getRequestsToAnotherEvents(long userId) {
        return null;
    }

    @Override
    public ParticipationRequestDto createRequestToAnotherEvent(long userId) {
        return null;
    }

    @Override
    public ParticipationRequestDto cancelRequestToAnotherEvent(long userId, long requestId) {
        return null;
    }
}
