package ru.practicum.explorewithme.request;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.practicum.explorewithme.request.dto.ParticipationRequestDto;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class RequestPrivateController {

    private final RequestService requestService;

    @GetMapping("/{userId}/requests")
    public List<ParticipationRequestDto> getRequestsToAnotherEvents(@PathVariable long userId) {
        return requestService.getRequestsToAnotherEvents(userId);
    }

    @PostMapping("/{userId}/requests")
    public ParticipationRequestDto createRequestToAnotherEvent(@PathVariable long userId,
                                                               @RequestParam long eventId) {
        return requestService.createRequestToAnotherEvent(userId, eventId);
    }

    @PatchMapping("/{userId}/requests/{requestId}/cancel")
    public ParticipationRequestDto cancelRequestToAnotherEvent(@PathVariable long userId, @PathVariable long requestId) {
        return requestService.cancelRequestToAnotherEvent(userId, requestId);
    }


}
