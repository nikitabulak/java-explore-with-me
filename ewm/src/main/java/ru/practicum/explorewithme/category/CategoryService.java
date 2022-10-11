package ru.practicum.explorewithme.category;

import ru.practicum.explorewithme.category.dto.CategoryDto;
import ru.practicum.explorewithme.category.dto.NewCategoryDto;

import java.util.List;

public interface CategoryService {
    //Public___________________________________________________
    List<CategoryDto> getAllCategories(int from, int size);

    CategoryDto getCategory(long catId);

    //Admin___________________________________________________
    CategoryDto editCategory(CategoryDto editingCategoryDto);

    CategoryDto createCategory(NewCategoryDto newCategoryDto);

    void deleteCategory(long catId);
}
