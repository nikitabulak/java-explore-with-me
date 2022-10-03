package ru.practicum.explorewithme.event.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NewEventHit {
    private String app;
    private String uri;
    private String ip;
    private String timestamp;
}
