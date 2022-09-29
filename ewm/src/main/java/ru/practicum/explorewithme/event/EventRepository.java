package ru.practicum.explorewithme.event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.practicum.explorewithme.event.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
}
