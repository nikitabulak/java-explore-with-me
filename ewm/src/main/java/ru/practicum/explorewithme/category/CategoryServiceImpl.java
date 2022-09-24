package ru.practicum.explorewithme.category;

import org.springframework.stereotype.Service;
import ru.practicum.explorewithme.category.dto.CategoryDto;
import ru.practicum.explorewithme.category.dto.NewCategoryDto;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Override
    public List<CategoryDto> getAllCategories() {
        return null;
    }

    @Override
    public CategoryDto getCategory(long catId) {
        return null;
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
