package ru.practicum.explorewithme.compilation;

import org.springframework.stereotype.Service;
import ru.practicum.explorewithme.compilation.dto.CompilationDto;
import ru.practicum.explorewithme.compilation.dto.NewCompilationDto;

import java.util.List;

@Service
public class CompilationServiceImpl implements CompilationService {
    @Override
    public List<CompilationDto> getAllCompilations() {
        return null;
    }

    @Override
    public CompilationDto getCompilation(long compId) {
        return null;
    }

    @Override
    public CompilationDto createCompilation(NewCompilationDto newCompilationDto) {
        return null;
    }

    @Override
    public void deleteCompilation(long compId) {

    }

    @Override
    public void deleteEventFromCompilation(long compId, long eventId) {

    }

    @Override
    public CompilationDto addEventToCompilation(long compId, long eventId) {
        return null;
    }

    @Override
    public void unpinCompilation(long compId) {

    }

    @Override
    public CompilationDto pinCompilation(long compId) {
        return null;
    }
}
