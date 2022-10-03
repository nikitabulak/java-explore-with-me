package ru.practicum.explorewithme.compilation;

import org.springframework.data.domain.Pageable;
import ru.practicum.explorewithme.compilation.dto.CompilationDto;
import ru.practicum.explorewithme.compilation.dto.NewCompilationDto;

import java.util.List;

public interface CompilationService {
    //Public___________________________________________________
    List<CompilationDto> getAllCompilations(boolean pinned, int from, int size);

    CompilationDto getCompilation(long compId);

    //Admin___________________________________________________
    CompilationDto createCompilation(NewCompilationDto newCompilationDto);

    void deleteCompilation(long compId);

    void deleteEventFromCompilation(long compId, long eventId);

    CompilationDto addEventToCompilation(long compId, long eventId);

    void unpinCompilation(long compId);

    CompilationDto pinCompilation(long compId);
}
