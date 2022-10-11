package ru.practicum.stats;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.practicum.stats.model.Hit;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface HitRepository extends JpaRepository<Hit, Long> {
    @Query("select i from Hit i " +
            "where i.timestamp >= ?1" +
            " and i.timestamp < ?2 " +
            " and i.uri in ?3 ")
    List<Hit> getHits(LocalDateTime start, LocalDateTime end, List<String> uris);
}
