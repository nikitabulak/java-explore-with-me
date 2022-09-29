package ru.practicum.explorewithme.compilation;

import ru.practicum.explorewithme.category.model.Category;
import ru.practicum.explorewithme.compilation.dto.CompilationDto;
import ru.practicum.explorewithme.compilation.dto.NewCompilationDto;
import ru.practicum.explorewithme.compilation.model.Compilation;
import ru.practicum.explorewithme.event.dto.*;
import ru.practicum.explorewithme.event.model.Event;
import ru.practicum.explorewithme.event.model.State;
import ru.practicum.explorewithme.user.UserMapper;
import ru.practicum.explorewithme.user.model.User;

import java.time.LocalDateTime;
import java.util.List;

public class CompilationMapper {
    public static CompilationDto toCompilationDto(Compilation compilation, List<EventShortDto> eventsList) {
        return new CompilationDto(
                compilation.getId(),
                compilation.getTitle(),
                compilation.isPinned(),
                eventsList
        );
    }

    public static Compilation toNewCompilation(NewCompilationDto newCompilationDto){
        return new Compilation(
                0,
                newCompilationDto.getTitle(),
                newCompilationDto.isPinned()
        );
    }
}
