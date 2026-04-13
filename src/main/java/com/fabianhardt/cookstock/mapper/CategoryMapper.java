package com.fabianhardt.cookstock.mapper;

import com.fabianhardt.cookstock.dto.category.CategoryResponse;
import com.fabianhardt.cookstock.dto.category.CreateCategoryRequest;
import com.fabianhardt.cookstock.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

//TODO JavaDoc
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CategoryMapper {

    CategoryResponse toDto(Category category);

    List<CategoryResponse> toDtoList(List<Category> categories);

    Category toEntity(CreateCategoryRequest request);
}
