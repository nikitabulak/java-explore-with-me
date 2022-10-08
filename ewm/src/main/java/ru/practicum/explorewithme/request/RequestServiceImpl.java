package ru.practicum.explorewithme.request;

import org.springframework.stereotype.Service;
import ru.practicum.explorewithme.event.EventRepository;
import ru.practicum.explorewithme.event.EventServiceImpl;
import ru.practicum.explorewithme.event.model.Event;
import ru.practicum.explorewithme.event.model.State;
import ru.practicum.explorewithme.exception.EventNotFoundException;
import ru.practicum.explorewithme.exception.ParticipantLimitReachedException;
import ru.practicum.explorewithme.exception.UserNotFoundException;
import ru.practicum.explorewithme.request.dto.ParticipationRequestDto;
import ru.practicum.explorewithme.request.model.Request;
import ru.practicum.explorewithme.request.model.Status;
import ru.practicum.explorewithme.user.UserRepository;
import ru.practicum.explorewithme.user.model.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RequestServiceImpl implements RequestService {
    private final RequestRepository requestRepository;
    private final EventRepository eventRepository;
    private final EventServiceImpl eventService;
    private final UserRepository userRepository;

    public RequestServiceImpl(RequestRepository requestRepository, EventRepository eventRepository, EventServiceImpl eventService, UserRepository userRepository) {
        this.requestRepository = requestRepository;
        this.eventRepository = eventRepository;
        this.eventService = eventService;
        this.userRepository = userRepository;
    }

    //Private___________________________________________________
    @Override
    public List<ParticipationRequestDto> getRequestsToAnotherEvents(long userId) {
        List<Request> requests = requestRepository.findAllByRequesterId(userId);
        return requests.stream()
                .map(RequestMapper::toParticipationRequestDto)
                .collect(Collectors.toList());
    }

    @Override
    public ParticipationRequestDto createRequestToAnotherEvent(long userId, long eventId) {
        Request request = requestRepository.findRequestByEventIdAndRequesterId(eventId, userId);
        Event event = eventRepository.findById(eventId).orElseThrow(() -> new EventNotFoundException("Событие с таким id не найдено"));
        if (request == null && userId != event.getInitiator().getId() && event.getState().equals(State.PUBLISHED)) {
            if (event.getParticipantLimit() == 0 || event.getParticipantLimit() > eventService.getConfirmedRequestsCount(event.getId())) {
                Status status = Status.PENDING;
                if (!event.isRequestModeration()) {
                    status = Status.CONFIRMED;
                }
                User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("Пользователь с таким id не найден"));
                request = new Request(0, user, event, LocalDateTime.now(), status);
                request = requestRepository.save(request);
                return RequestMapper.toParticipationRequestDto(request);
            } else {
                throw new ParticipantLimitReachedException();
            }
        } else {
            throw new IllegalArgumentException(String.format("Can't create request to event with id = %d from user with id = %d", eventId, userId));
        }
    }


    @Override
    public ParticipationRequestDto cancelRequestToAnotherEvent(long userId, long requestId) {
        Request request = requestRepository.findRequestByIdAndRequesterId(requestId, userId);
        if (request != null) {
            request.setStatus(Status.CANCELED);
            request = requestRepository.save(request);
            return RequestMapper.toParticipationRequestDto(request);
        } else {
            throw new IllegalArgumentException(String.format("Can't find request with id = %d from user with id = %d", requestId, userId));
        }
    }
}


