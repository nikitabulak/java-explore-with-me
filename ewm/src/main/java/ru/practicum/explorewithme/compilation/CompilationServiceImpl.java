package ru.practicum.explorewithme.compilation;

import org.springframework.stereotype.Service;
import ru.practicum.explorewithme.compilation.dto.CompilationDto;
import ru.practicum.explorewithme.compilation.dto.NewCompilationDto;
import ru.practicum.explorewithme.compilation.model.Compilation;
import ru.practicum.explorewithme.event.EventMapper;
import ru.practicum.explorewithme.event.EventRepository;
import ru.practicum.explorewithme.event.EventService;
import ru.practicum.explorewithme.event.EventServiceImpl;
import ru.practicum.explorewithme.event.model.Event;
import ru.practicum.explorewithme.exception.CompilationNotFoundException;
import ru.practicum.explorewithme.exception.EventNotFoundException;
import ru.practicum.explorewithme.pageable.OffsetLimitPageable;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompilationServiceImpl implements CompilationService {

    private final CompilationRepository compilationRepository;
    private final EventRepository eventRepository;
    private final EventServiceImpl eventService;

    public CompilationServiceImpl(CompilationRepository compilationRepository, EventRepository eventRepository, EventServiceImpl eventService) {
        this.compilationRepository = compilationRepository;
        this.eventRepository = eventRepository;
        this.eventService = eventService;
    }

    @Override
    public List<CompilationDto> getAllCompilations(boolean pinned, int from, int size) {
        List<Compilation> compilations = compilationRepository.findAllByPinnedIs(pinned, OffsetLimitPageable.of(from, size));
        return compilations.stream()
                .map(x -> CompilationMapper.toCompilationDto(x, x.getEvents().stream()
                        .map(k -> EventMapper.toEventShortDto(k, eventService.getConfirmedRequestsCount(k.getId()), eventService.getEventViews(k)))
                        .collect(Collectors.toList())))
                .collect(Collectors.toList());
    }

    @Override
    public CompilationDto getCompilation(long compId) {
        Compilation compilation = compilationRepository.findById(compId).orElseThrow(() -> new CompilationNotFoundException("Подборка с таким id не найдена!"));
        return CompilationMapper.toCompilationDto(compilation, compilation.getEvents().stream()
                .map(k -> EventMapper.toEventShortDto(k, eventService.getConfirmedRequestsCount(k.getId()), eventService.getEventViews(k)))
                .collect(Collectors.toList()));
    }

    @Override
    public CompilationDto createCompilation(NewCompilationDto newCompilationDto) {
        Compilation compilation = CompilationMapper.toNewCompilation(newCompilationDto);
        compilation = compilationRepository.save(compilation);
        return CompilationMapper.toCompilationDto(compilation, compilation.getEvents().stream()
                .map(k -> EventMapper.toEventShortDto(k, eventService.getConfirmedRequestsCount(k.getId()), eventService.getEventViews(k)))
                .collect(Collectors.toList()));
    }

    @Override
    public void deleteCompilation(long compId) {
        if (compilationRepository.existsById(compId)) {
            compilationRepository.deleteById(compId);
        }
    }

    @Override
    public void deleteEventFromCompilation(long compId, long eventId) {
        Compilation compilation = compilationRepository.findById(compId).orElseThrow(() -> new CompilationNotFoundException("Подборка с таким id не найдена!"));
        Event event = eventRepository.findById(eventId).orElseThrow(() -> new EventNotFoundException("Событие с таким id не найдено!"));
        compilation.getEvents().remove(event);
        compilationRepository.save(compilation);
    }

    @Override
    public CompilationDto addEventToCompilation(long compId, long eventId) {
        Compilation compilation = compilationRepository.findById(compId).orElseThrow(() -> new CompilationNotFoundException("Подборка с таким id не найдена!"));
        Event event = eventRepository.findById(eventId).orElseThrow(() -> new EventNotFoundException("Событие с таким id не найдено!"));
        compilation.getEvents().add(event);
        compilation = compilationRepository.save(compilation);
        return CompilationMapper.toCompilationDto(compilation, compilation.getEvents().stream()
                .map(k -> EventMapper.toEventShortDto(k, eventService.getConfirmedRequestsCount(k.getId()), eventService.getEventViews(k)))
                .collect(Collectors.toList()));
    }

    @Override
    public void unpinCompilation(long compId) {
        Compilation compilation = compilationRepository.findById(compId).orElseThrow(() -> new CompilationNotFoundException("Подборка с таким id не найдена!"));
        compilation.setPinned(false);
        compilationRepository.save(compilation);
    }

    @Override
    public CompilationDto pinCompilation(long compId) {
        Compilation compilation = compilationRepository.findById(compId).orElseThrow(() -> new CompilationNotFoundException("Подборка с таким id не найдена!"));
        compilation.setPinned(true);
        compilation = compilationRepository.save(compilation);
        return CompilationMapper.toCompilationDto(compilation, compilation.getEvents().stream()
                .map(k -> EventMapper.toEventShortDto(k, eventService.getConfirmedRequestsCount(k.getId()), eventService.getEventViews(k)))
                .collect(Collectors.toList()));
    }
}
