package ru.practicum.explorewithme.request.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Table(name = "users")
public class AdminUpdateEventRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
}
