package ru.practicum.explorewithme.category;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.practicum.explorewithme.category.dto.CategoryDto;
import ru.practicum.explorewithme.category.dto.NewCategoryDto;
import ru.practicum.explorewithme.category.model.Category;
import ru.practicum.explorewithme.event.EventRepository;
import ru.practicum.explorewithme.event.model.Event;
import ru.practicum.explorewithme.exception.CategoryNotFoundException;
import ru.practicum.explorewithme.pageable.OffsetLimitPageable;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final EventRepository eventRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository, EventRepository eventRepository) {
        this.categoryRepository = categoryRepository;
        this.eventRepository = eventRepository;
    }

    @Override
    public List<CategoryDto> getAllCategories(int from, int size) {
        return categoryRepository.findAll(OffsetLimitPageable.of(from, size)).stream()
                .map(CategoryMapper::toCategoryDto)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto getCategory(long catId) {
        return CategoryMapper.toCategoryDto(categoryRepository.findById(catId).orElseThrow(() -> new CategoryNotFoundException("Категория с таким id не найдена!")));
    }

    @Override
    public CategoryDto editCategory(CategoryDto editingCategoryDto) {
        Category category = categoryRepository.findById(editingCategoryDto.getId()).orElseThrow(() -> new CategoryNotFoundException("Категория с таким id не найдена!"));
        category.setName(editingCategoryDto.getName());
        category = categoryRepository.save(category);
        return CategoryMapper.toCategoryDto(category);
    }

    @Override
    @Transactional
    public CategoryDto createCategory(NewCategoryDto newCategoryDto) {
        Category category = CategoryMapper.toNewCategory(newCategoryDto);
        category = categoryRepository.save(category);
        return CategoryMapper.toCategoryDto(category);
    }

    @Override
    @Transactional
    public void deleteCategory(long catId) {
        List<Event> events = eventRepository.findEventsByCategoryId(catId);
        if (events.isEmpty()) {
            categoryRepository.deleteById(catId);
        } else {
            throw new IllegalArgumentException("С данной категорией связаны события");
        }
    }
}
