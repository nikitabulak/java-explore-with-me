package ru.practicum.explorewithme.request;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.practicum.explorewithme.request.model.Request;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {
}
