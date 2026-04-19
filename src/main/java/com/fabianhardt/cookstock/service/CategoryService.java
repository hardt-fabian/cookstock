package com.fabianhardt.cookstock.service;

import com.fabianhardt.cookstock.dto.category.CategoryResponse;
import com.fabianhardt.cookstock.dto.category.CreateCategoryRequest;
import com.fabianhardt.cookstock.entity.Category;
import com.fabianhardt.cookstock.exception.CategoryAlreadyExistsException;
import com.fabianhardt.cookstock.exception.CategoryNotFoundException;
import com.fabianhardt.cookstock.mapper.CategoryMapper;
import com.fabianhardt.cookstock.repository.CategoryRepository;
import com.fabianhardt.cookstock.repository.ItemRepository;
import com.fabianhardt.cookstock.repository.ShoppingItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing categories.
 * <p>
 * This class provides business logic for creating, reading and deleting categories. It acts as
 * an intermediary between the persistence layer {@link CategoryRepository}
 * and the presentation layer CategoryController.
 * </p>
 *
 * @author Fabian Hardt
 */
@Service
public class CategoryService {

    /**
     * Interface to the category repository
     */
    private final CategoryRepository categoryRepository;

    /**
     * Interface to the item repository
     */
    private final ItemRepository itemRepository;

    /**
     * Interface to the shopping item repository
     */
    private final ShoppingItemRepository shoppingItemRepository;

    /**
     * Helper to map data transfer objects to categories and vice versa
     */
    private final CategoryMapper categoryMapper;

    /**
     * Constructor
     *
     * @param itemRepository Interface to the item repository
     * @param categoryRepository Interface to the category repository
     * @param shoppingItemRepository Interface to the shopping item repository
     * @param categoryMapper Helper to map data transfer objects to categories and vice versa
     */
    public CategoryService(CategoryRepository categoryRepository, ItemRepository itemRepository,
            ShoppingItemRepository shoppingItemRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.itemRepository = itemRepository;
        this.shoppingItemRepository = shoppingItemRepository;
        this.categoryMapper = categoryMapper;
    }

    /**
     * Returns the newly created category, created by the overhanded data transfer object
     *
     * @param request dto to create a new category
     * @return the newly created category as as {@link CategoryResponse}
     * @throws CategoryAlreadyExistsException if a category with the given name already exists
     */
    public CategoryResponse createCategory(CreateCategoryRequest request) {
        String categoryName = request.getName();
        if (this.categoryRepository.existsByName(categoryName)) {
            throw new CategoryAlreadyExistsException(categoryName);
        }

        Category category = this.categoryMapper.toEntity(request);
        return this.categoryMapper.toDto(this.categoryRepository.save(category));
    }

    /**
     * Returns an {@code Optional} with the category as value or an empty {@code Optional}
     * if no category with the specified id exists.
     *
     * @param id the id of the searched category
     * @return {@code Optional} with the category as {@link CategoryResponse} or
     * empty {@code Optional}
     */
    public Optional<CategoryResponse> getCategoryById(Long id) {
        return this.categoryRepository.findById(id).map(this.categoryMapper::toDto);
    }

    /**
     * Returns all categories.
     *
     * @return all categories as as {@link CategoryResponse}
     */
    public List<CategoryResponse> getAllCategories() {
        List<Category> categories = this.categoryRepository.findAll();
        return this.categoryMapper.toDtoList(categories);
    }

    /**
     * Deletes the category with the given id.
     * It also removes the category from all items.
     *
     * @param id the id of the category which should be deleted
     * @throws CategoryNotFoundException if no item with the given id exists
     */
    @Transactional
    public void deleteCategory(Long id) {
        Category category = this.categoryRepository.findById(id).orElseThrow(
                () -> new CategoryNotFoundException(id));
        this.itemRepository.removeCategoryFromItems(category);
        this.shoppingItemRepository.removeCategoryFromShoppingItems(category);
        this.categoryRepository.delete(category);
    }
}
