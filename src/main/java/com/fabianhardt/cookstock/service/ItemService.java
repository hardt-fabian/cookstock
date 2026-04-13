package com.fabianhardt.cookstock.service;

import com.fabianhardt.cookstock.entity.Category;
import com.fabianhardt.cookstock.entity.Item;
import com.fabianhardt.cookstock.dto.item.CreateItemRequest;
import com.fabianhardt.cookstock.dto.item.ItemResponse;
import com.fabianhardt.cookstock.dto.item.UpdateItemRequest;
import com.fabianhardt.cookstock.entity.Location;
import com.fabianhardt.cookstock.exception.*;
import com.fabianhardt.cookstock.mapper.ItemMapper;
import com.fabianhardt.cookstock.repository.CategoryRepository;
import com.fabianhardt.cookstock.repository.ItemRepository;
import com.fabianhardt.cookstock.repository.LocationRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing items.
 * <p>
 * This class provides business logic for creating, updating, sorting and reading
 * items. It acts as an intermediary between the persistence layer {@link ItemRepository}
 * and the presentation layer ItemController.
 * </p>
 *
 * @author Fabian Hardt
 */
@Service
public class ItemService {

    /**
     * Interface to the item repository
     */
    private final ItemRepository itemRepository;

    /**
     * Interface to the location repository
     */
    private final LocationRepository locationRepository;

    /**
     * Interface to the category repository
     */
    private final CategoryRepository categoryRepository;

    /**
     * Helper to map data transfer objects to items and vice versa
     */
    private final ItemMapper itemMapper;

    /**
     * Constructor
     *
     * @param itemRepository Interface to the item repository
     * @param locationRepository Interface to the location repository
     * @param categoryRepository Interface to the category repository
     * @param itemMapper Helper to map data transfer objects to items and vice versa
     */
    public ItemService(ItemRepository itemRepository, LocationRepository locationRepository,
            CategoryRepository categoryRepository, ItemMapper itemMapper) {
        this.itemRepository = itemRepository;
        this.locationRepository = locationRepository;
        this.categoryRepository = categoryRepository;
        this.itemMapper = itemMapper;
    }

    /**
     * Returns the newly created item, created by the overhanded data transfer object.
     *
     * @param request dto to create a new item
     * @return the newly created item as as {@link ItemResponse}
     * @throws ItemAlreadyExistsException if an item with the given name already exists
     */
    public ItemResponse createItem(CreateItemRequest request) {
        String itemName = request.getName();
        Optional<Item> itemByName =
                this.itemRepository.findByName(itemName);
        if (itemByName.isPresent()) {
            throw new ItemAlreadyExistsException(itemName);
        }
        Item item = this.itemMapper.toEntity(request);
        this.itemRepository.save(item);
        return this.itemMapper.toDto(item);
    }

    /**
     * Returns an {@code Optional} with the item as value or an empty {@code Optional} if no item
     * with the specified id exists.
     *
     * @param id the id of the searched item
     * @return {@code Optional} with the item as {@link ItemResponse} or empty {@code Optional}
     */
    public Optional<ItemResponse> getItemById(Long id) {
        return this.itemRepository.findById(id).map(this.itemMapper::toDto);
    }

    /**
     * Returns all items at the location with the specified location id.
     *
     * @param locationId Identifier of the location
     * @return all items as as {@link ItemResponse}
     */
    public List<ItemResponse> getItemsByLocation(Long locationId) {
        Location location = this.locationRepository.findById(locationId)
                .orElseThrow(() -> new LocationNotFoundException(locationId));

        return this.itemMapper.toDtoList(this.itemRepository.findByLocation(location));
    }

    /**
     * Returns all items.
     *
     * @return all items as as {@link ItemResponse}
     */
    public List<ItemResponse> getAllItems() {
        List<Item> items = this.itemRepository.findAll();
        return this.itemMapper.toDtoList(items);
    }

    /**
     * Updates the item with the given id.
     *
     * @param id the id of the item to update
     * @param update the data used to update the item
     * @return the updated item as {@link ItemResponse}
     * @throws ItemNotFoundException if no item with the given id exists
     */
    public ItemResponse updateItem(Long id, UpdateItemRequest update) {
        Item item = this.itemRepository.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
        if (update.getName().isPresent()) {
            item.setName(update.getName().get());
        }
        update.getQuantity().ifPresent(item::setQuantity);
        update.getUnit().ifPresent(item::setUnit);
        update.getExpirationDate().ifPresent(item::setExpirationDate);
        update.getMinQuantity().ifPresent(item::setMinQuantity);
        if (update.getCategoryId().isPresent()) {
            Long categoryId = update.getCategoryId().get();
            if (categoryId == null) {
                item.setCategory(null);
            } else {
                Category category = this.categoryRepository.findById(categoryId).orElseThrow(() -> new CategoryNotFoundException(categoryId));
                item.setCategory(category);
            }
        }
        if (update.getLocationId().isPresent()) {
            Long locationId = update.getLocationId().get();
            if (locationId == null) {
                item.setCategory(null);
            } else {
                Location location =
                        this.locationRepository.findById(locationId).orElseThrow(() -> new LocationNotFoundException(locationId));
                item.setLocation(location);
            }
        }

        this.itemRepository.save(item);
        return this.itemMapper.toDto(item);
    }

    /**
     * Deletes the item with the given id.
     *
     * @param id the id of the item which should be deleted
     * @throws ItemNotFoundException if no item with the given id exists
     */
    public void deleteItem(Long id) {
        Item item = this.itemRepository.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
        this.itemRepository.delete(item);
    }
}
