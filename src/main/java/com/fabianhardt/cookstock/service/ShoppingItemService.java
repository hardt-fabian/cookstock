package com.fabianhardt.cookstock.service;

import com.fabianhardt.cookstock.dto.shoppingItem.CreateShoppingItemRequest;
import com.fabianhardt.cookstock.dto.shoppingItem.ShoppingItemResponse;
import com.fabianhardt.cookstock.dto.shoppingItem.UpdateShoppingItemRequest;
import com.fabianhardt.cookstock.entity.Category;
import com.fabianhardt.cookstock.entity.ShoppingItem;
import com.fabianhardt.cookstock.entity.ShoppingList;
import com.fabianhardt.cookstock.exception.CategoryNotFoundException;
import com.fabianhardt.cookstock.exception.InvalidFieldException;
import com.fabianhardt.cookstock.exception.ShoppingItemNotFoundException;
import com.fabianhardt.cookstock.exception.ShoppingListNotFoundException;
import com.fabianhardt.cookstock.mapper.ShoppingItemMapper;
import com.fabianhardt.cookstock.repository.CategoryRepository;
import com.fabianhardt.cookstock.repository.ShoppingItemRepository;
import com.fabianhardt.cookstock.repository.ShoppingListRepository;
import jakarta.transaction.Transactional;
import org.apache.tomcat.util.http.fileupload.InvalidFileNameException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing shopping items.
 * <p>
 * This class provides business logic for creating, updating, sorting and reading
 * shopping items. It acts as an intermediary between the persistence layer
 * {@link ShoppingItemRepository} and the presentation layer ShoppingItemController.
 * </p>
 *
 * @author Fabian Hardt
 */
@Service
public class ShoppingItemService {

    /**
     * Interface to the shopping item repository
     */
    private final ShoppingItemRepository shoppingItemRepository;

    /**
     * Interface to the category repository
     */
    private final CategoryRepository categoryRepository;

    /**
     * Interface to the shopping list repository
     */
    private final ShoppingListRepository  shoppingListRepository;

    /**
     * Helper to map data transfer objects to shopping items and vice versa
     */
    private final ShoppingItemMapper shoppingItemMapper;

    /**
     * Constructor
     *
     * @param shoppingItemRepository Interface to the shopping item repository
     * @param categoryRepository Interface to the category repository
     * @param shoppingListRepository Interface to the shopping list repository
     * @param shoppingItemMapper Helper to map data transfer objects to shopping items and vice
     *                           versa
     */
    public ShoppingItemService(ShoppingItemRepository shoppingItemRepository,
            CategoryRepository categoryRepository, ShoppingListRepository shoppingListRepository,
            ShoppingItemMapper shoppingItemMapper) {
        this.shoppingItemRepository = shoppingItemRepository;
        this.categoryRepository = categoryRepository;
        this.shoppingListRepository = shoppingListRepository;
        this.shoppingItemMapper = shoppingItemMapper;
    }

    /**
     * Returns the newly created shopping item, created by the overhanded data transfer object.
     *
     * @param request dto to create a new shopping item
     * @return the newly created shopping item as as {@link ShoppingItemResponse}
     */
    public ShoppingItemResponse createShoppingItem(CreateShoppingItemRequest request) {
        ShoppingItem shoppingItem = this.shoppingItemMapper.toEntity(request);
        if (request.getCategoryId() != null) {
            Category category = this.categoryRepository.findById(request.getCategoryId()).orElseThrow(() -> new CategoryNotFoundException(request.getCategoryId()));
            shoppingItem.setCategory(category);
        }
        if (request.getShoppingListId() == null) {
            throw new InvalidFieldException("ShoppingListId is required");
        }
        ShoppingList shoppingList =
                this.shoppingListRepository.findById(request.getShoppingListId()).orElseThrow(() -> new ShoppingListNotFoundException(request.getShoppingListId()));
        shoppingItem.setShoppingList(shoppingList);

        this.shoppingItemRepository.save(shoppingItem);
        return this.shoppingItemMapper.toDto(shoppingItem);
    }

    /**
     * Returns an {@code Optional} with the shopping item as value or an empty {@code Optional}
     * if no shopping item
     * with the specified id exists.
     *
     * @param id the id of the searched shopping item
     * @return {@code Optional} with the shopping item as {@link ShoppingItemResponse} or empty
     * {@code Optional}
     */
    public Optional<ShoppingItemResponse> getShoppingItemById(Long id) {
        return this.shoppingItemRepository.findById(id).map(this.shoppingItemMapper::toDto);
    }

    /**
     * Returns all shopping items.
     *
     * @return all shopping items as as {@link ShoppingItemResponse}
     */
    public List<ShoppingItemResponse> getAllShoppingItems() {
        List<ShoppingItem> shoppingItems = this.shoppingItemRepository.findAll();
        return this.shoppingItemMapper.toDtoList(shoppingItems);
    }

    /**
     * Updates the shopping item with the given id.
     *
     * @param id the id of the shopping item to update
     * @param update the data used to update the shopping item
     * @return the updated shopping item as {@link ShoppingItemResponse}
     * @throws ShoppingItemNotFoundException if no shopping item with the given id exists
     * @throws CategoryNotFoundException if no category with the given category id exists
     * @throws ShoppingListNotFoundException if no shopping list with the given shopping list id exists
     */
    public ShoppingItemResponse updateItem(Long id, UpdateShoppingItemRequest update) {
        ShoppingItem shoppingItem = this.shoppingItemRepository.findById(id).orElseThrow(() -> new ShoppingItemNotFoundException(id));
        if (update.getQuantity().isPresent()) {
            shoppingItem.setQuantity(update.getQuantity().orElse(null));
        }
        update.getQuantity().ifPresent(shoppingItem::setQuantity);
        update.getUnit().ifPresent(shoppingItem::setUnit);
        if (update.getPurchased().isPresent()) {
            if (update.getPurchased() == null) {
                throw new InvalidFieldException("purchased cannot be null");
            }
        }
        if (update.getCategoryId().isPresent()) {
            Long categoryId = update.getCategoryId().get();
            if (categoryId == null) {
                shoppingItem.setCategory(null);
            } else {
                Category category = this.categoryRepository.findById(categoryId).orElseThrow(() -> new CategoryNotFoundException(categoryId));
                shoppingItem.setCategory(category);
            }
        }
        if (update.getShoppingListId().isPresent()) {
            Long shoppingListId = update.getShoppingListId().get();
            if (shoppingListId == null) {
                throw new InvalidFieldException("shoppingListId cannot be null");
            } else {
                ShoppingList shoppingList =
                        this.shoppingListRepository.findById(shoppingListId).orElseThrow(() -> new ShoppingListNotFoundException(shoppingListId));
                shoppingItem.setShoppingList(shoppingList);
            }
        }

        this.shoppingItemRepository.save(shoppingItem);
        return this.shoppingItemMapper.toDto(shoppingItem);
    }

    /**
     * Deletes the shopping item with the given id.
     *
     * @param id the id of the shopping item which should be deleted
     * @throws ShoppingItemNotFoundException if no shopping item with the given id exists
     */
    public void deleteShoppingItem(Long id) {
        ShoppingItem shoppingItem = this.shoppingItemRepository.findById(id).orElseThrow(() -> new ShoppingItemNotFoundException(id));
        shoppingItem.getShoppingList().getShoppingItemList().remove(shoppingItem);
        this.shoppingItemRepository.delete(shoppingItem);
    }
}
