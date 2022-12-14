package ru.practicum.explorewithme.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserShortDto {
    private long id;
    private String name;
}
