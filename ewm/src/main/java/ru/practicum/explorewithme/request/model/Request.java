package ru.practicum.explorewithme.request.model;

import lombok.*;
import ru.practicum.explorewithme.event.model.Event;
import ru.practicum.explorewithme.user.model.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "requests")
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "requester_id", referencedColumnName = "id")
    private User requester;
    @NotNull
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    private Event event;
    @NotNull
    private LocalDateTime created;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status;
}
