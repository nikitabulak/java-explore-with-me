package ru.practicum.explorewithme.request;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.practicum.explorewithme.request.model.Request;
import ru.practicum.explorewithme.request.model.Status;

import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {
    List<Request> findByEventIdAndStatus(long eventId, Status status);

    List<Request> findAllByEventIdAndEventInitiatorId(long eventId, long userId);

    Request findRequestByIdAndEventIdAndEventInitiatorId(long reqId, long eventId, long userId);

    List<Request> findAllByEventIdAndStatus(long eventId, Status status);

    List<Request> findAllByRequesterId(long userId);

    Request findRequestByEventIdAndRequesterId(long eventId, long requesterId);

    Request findRequestByIdAndRequesterId(long requestId, long requesterId);
}
