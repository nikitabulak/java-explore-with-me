package ru.practicum.explorewithme.event;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.practicum.explorewithme.event.model.Event;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    @Query("select i from Event i " +
            "where (upper(i.annotation) like upper(concat('%', ?1, '%')) " +
            " or upper(i.description) like upper(concat('%', ?1, '%'))) ")
//            " and i.state like 'PUBLISHED'")
    List<Event> search(String text);

    @Query("select i from Event i " +
            "where (upper(i.annotation) like upper(concat('%', ?1, '%')) " +
            " or upper(i.description) like upper(concat('%', ?1, '%'))) " +
            " and i.category in ?2 " +
            " and i.paid = ?3 " +
            " and i.eventDate > ?4 " +
            " and i.eventDate < ?5 ")
//            " and i.state like 'PUBLISHED'")
    List<Event> getEvents(String text,
                          List<Long> categories,
                          boolean paid,
                          LocalDateTime rangeStart,
                          LocalDateTime rangeEnd,
                          Pageable pageable);
    List<Event> findAllByInitiatorId(long userId, Pageable pageable);
    Event findEventByIdAndInitiatorId(long eventId, long userId);
}
