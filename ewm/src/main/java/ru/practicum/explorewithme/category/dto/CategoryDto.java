package ru.practicum.explorewithme.category.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryDto {
    private long id;
    @NotNull
    @NotBlank
    private String name;
}
