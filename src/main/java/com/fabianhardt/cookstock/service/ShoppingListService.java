package com.fabianhardt.cookstock.service;

import com.fabianhardt.cookstock.dto.shoppingList.CreateShoppingListRequest;
import com.fabianhardt.cookstock.dto.shoppingList.ShoppingListResponse;
import com.fabianhardt.cookstock.entity.ShoppingItem;
import com.fabianhardt.cookstock.entity.ShoppingList;
import com.fabianhardt.cookstock.exception.DefaultShoppingListAlreadyExistsException;
import com.fabianhardt.cookstock.exception.DefaultShoppingListDeletionException;
import com.fabianhardt.cookstock.exception.ShoppingListAlreadyExistsException;
import com.fabianhardt.cookstock.exception.ShoppingListNotFoundException;
import com.fabianhardt.cookstock.mapper.ShoppingItemMapper;
import com.fabianhardt.cookstock.mapper.ShoppingListMapper;
import com.fabianhardt.cookstock.repository.ShoppingItemRepository;
import com.fabianhardt.cookstock.repository.ShoppingListRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing shopping lists.
 * <p>
 * This class provides business logic for creating, reading and deleting shopping lists. It acts as
 * an intermediary between the persistence layer {@link ShoppingListRepository}
 * and the presentation layer ShoppingListController.
 * </p>
 *
 * @author Fabian Hardt
 */
@Service
public class ShoppingListService {

    /**
     * Interface to the shopping list repository
     */
    private final ShoppingListRepository shoppingListRepository;

    /**
     * Interface to the shopping item repository
     */
    private final ShoppingItemRepository shoppingItemRepository;

    /**
     * Helper to map data transfer objects to shopping lists and vice versa
     */
    private final ShoppingListMapper shoppingListMapper;

    /**
     * Helper to map data transfer objects to shopping items and vice versa
     */
    private final ShoppingItemMapper shoppingItemMapper;

    /**
     * Constructor
     *
     * @param shoppingListRepository Interface to the shopping list repository
     * @param shoppingItemRepository Interface to the shopping item repository
     * @param shoppingListMapper Helper to map data transfer objects to shopping lists and
     *                           vice versa
     * @param shoppingItemMapper Helper to map data transfer objects to shopping items and
     *                           vice versa
     */
    public ShoppingListService(ShoppingListRepository shoppingListRepository,
            ShoppingItemRepository shoppingItemRepository,
            ShoppingListMapper shoppingListMapper, ShoppingItemMapper shoppingItemMapper) {
        this.shoppingListRepository = shoppingListRepository;
        this.shoppingItemRepository = shoppingItemRepository;
        this.shoppingListMapper = shoppingListMapper;
        this.shoppingItemMapper = shoppingItemMapper;
    }

    /**
     * Returns the newly created shoppingList, created by the overhanded data transfer object
     *
     * @param request dto to create a new shoppingList
     * @return the newly created shoppingList as as {@link ShoppingListResponse}
     * @throws DefaultShoppingListAlreadyExistsException if the new shopping list should be a
     * default shopping list but a default shopping list already exists
     * @throws ShoppingListAlreadyExistsException if a shoppingList with the given name already
     * exists
     */
    public ShoppingListResponse createShoppingList(CreateShoppingListRequest request) {
        boolean defaultListExists = this.shoppingListRepository.existsByDefaultListTrue();
        if (defaultListExists && request.isDefaultList()) {
            throw new DefaultShoppingListAlreadyExistsException();
        }

        String shoppingListName = request.getName();
        if (this.shoppingListRepository.existsByName(shoppingListName)) {
            throw new ShoppingListAlreadyExistsException(shoppingListName);
        }

        ShoppingList shoppingList = this.shoppingListMapper.toEntity(request);
        if (!defaultListExists) {
            shoppingList.setDefaultList(true);
        }
        if (request.getShoppingItems() != null) {
            List<ShoppingItem> items = request.getShoppingItems().stream().map(itemResponse -> {
                ShoppingItem item = this.shoppingItemMapper.toEntity(itemResponse);
                item.setShoppingList(shoppingList);
                return item;
            }).toList();
            shoppingList.setShoppingItemList(items);
        }

        return this.shoppingListMapper.toDto(this.shoppingListRepository.save(shoppingList));
    }

    /**
     * Returns an {@code Optional} with the shoppingList as value or an empty {@code Optional}
     * if no shoppingList with the specified id exists.
     *
     * @param id the id of the searched shoppingList
     * @return {@code Optional} with the shoppingList as {@link ShoppingListResponse} or
     * empty {@code Optional}
     */
    public Optional<ShoppingListResponse> getShoppingListById(Long id) {
        return this.shoppingListRepository.findById(id).map(this.shoppingListMapper::toDto);
    }

    /**
     * Returns all shoppingLists.
     *
     * @return all shoppingLists as as {@link ShoppingListResponse}
     */
    public List<ShoppingListResponse> getAllShoppingLists() {
        List<ShoppingList> shoppingLists = this.shoppingListRepository.findAll();
        return this.shoppingListMapper.toDtoList(shoppingLists);
    }

    /**
     * Deletes the shopping list with the given id.
     * It also deletes all shopping items of the shopping list.
     *
     * @param id the id of the shopping list which should be deleted
     * @throws ShoppingListNotFoundException if no item with the given id exists
     * @throws DefaultShoppingListDeletionException if the shopping list is a default list.
     */
    @Transactional
    public void deleteShoppingList(Long id) {
        ShoppingList shoppingList = this.shoppingListRepository.findById(id).orElseThrow(
                () -> new ShoppingListNotFoundException(id));
        if (shoppingList.isDefaultList()) {
            throw new DefaultShoppingListDeletionException();
        }

        this.shoppingItemRepository.deleteAllByShoppingList(shoppingList);
        this.shoppingListRepository.delete(shoppingList);
    }
}
