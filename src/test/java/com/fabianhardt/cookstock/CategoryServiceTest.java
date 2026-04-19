package com.fabianhardt.cookstock;

import com.fabianhardt.cookstock.dto.category.CategoryResponse;
import com.fabianhardt.cookstock.entity.Category;
import com.fabianhardt.cookstock.mapper.CategoryMapper;
import com.fabianhardt.cookstock.repository.CategoryRepository;
import com.fabianhardt.cookstock.service.CategoryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private CategoryMapper categoryMapper;

    @InjectMocks
    private CategoryService service;

    @Test
    void testGetAll() {

        // given
        Category category = new Category(1L, "Obst", null);
        List<Category> categories = List.of(category);

        CategoryResponse response = new CategoryResponse();
        List<CategoryResponse> responses = List.of(response);

        when(categoryRepository.findAll())
                .thenReturn(categories);

        when(categoryMapper.toDtoList(categories))
                .thenReturn(responses);

        // when
        List<CategoryResponse> result = service.getAllCategories();

        // then
        assertEquals(1, result.size());
    }
}
