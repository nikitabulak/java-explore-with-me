package ru.practicum.explorewithme.compilation;

import ru.practicum.explorewithme.compilation.dto.CompilationDto;
import ru.practicum.explorewithme.compilation.dto.NewCompilationDto;
import ru.practicum.explorewithme.compilation.model.Compilation;
import ru.practicum.explorewithme.event.dto.EventShortDto;
import ru.practicum.explorewithme.event.model.Event;

import java.util.Set;

public class CompilationMapper {
    public static CompilationDto toCompilationDto(Compilation compilation, Set<EventShortDto> eventsList) {
        return new CompilationDto(
                compilation.getId(),
                compilation.getTitle(),
                compilation.isPinned(),
                eventsList
        );
    }

    public static Compilation toNewCompilation(NewCompilationDto newCompilationDto, Set<Event> eventSet) {
        return new Compilation(
                0,
                newCompilationDto.getTitle(),
                newCompilationDto.isPinned(),
                eventSet
        );
    }
}
