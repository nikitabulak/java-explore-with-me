package ru.practicum.explorewithme.category;

import org.springframework.stereotype.Service;
import ru.practicum.explorewithme.category.dto.CategoryDto;
import ru.practicum.explorewithme.category.dto.NewCategoryDto;
import ru.practicum.explorewithme.exception.CategoryNotFoundException;
import ru.practicum.explorewithme.pageable.OffsetLimitPageable;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
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
        return null;
    }

    @Override
    public CategoryDto createCategory(NewCategoryDto newCategoryDto) {
        return null;
    }

    @Override
    public void deleteCategory(long catId) {

    }
}
