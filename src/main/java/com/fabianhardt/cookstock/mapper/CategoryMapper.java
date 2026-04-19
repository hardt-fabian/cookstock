package com.fabianhardt.cookstock.mapper;

import com.fabianhardt.cookstock.dto.category.CategoryResponse;
import com.fabianhardt.cookstock.dto.category.CreateCategoryRequest;
import com.fabianhardt.cookstock.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

/**
 * Helper class to map data transfer objects to categories and vice versa
 *
 * @author Fabian Hardt
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CategoryMapper {

    /**
     * Returns a mapped {@link CategoryResponse} for the specified category
     *
     * @param category the category which should be mapped
     * @return a mapped {@link CategoryResponse} for the specified category
     */
    CategoryResponse toDto(Category category);

    /**
     * Returns a liste of mapped {@link CategoryResponse} for the specified categories
     *
     * @param categories the categories which should be mapped
     * @return a liste of mapped {@link CategoryResponse} for the specified categories
     */
    List<CategoryResponse> toDtoList(List<Category> categories);

    /**
     * Returns the corresponding {@link Category} for the specified create category request
     *
     * @param request request data to create a category
     * @return the corresponding {@link Category} for the specified create category request
     */
    Category toEntity(CreateCategoryRequest request);
}
