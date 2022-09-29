package ru.practicum.explorewithme.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {
    private long id;
    @NotNull
    @NotBlank
    private String name;
    //    @Email(groups = {UserUpdate.class, Default.class})
    @Email
    @NotNull
    @NotBlank
    private String email;
}
