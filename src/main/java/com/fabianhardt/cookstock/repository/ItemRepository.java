package com.fabianhardt.cookstock.repository;

import com.fabianhardt.cookstock.entity.Category;
import com.fabianhardt.cookstock.entity.Item;
import com.fabianhardt.cookstock.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for the access to the {@link Item}-Entities.
 * <p>
 * This interface extends {@link JpaRepository} and provides basic CRUD-Operations for
 * {@link Item}-Objects.
 * </p>
 *
 * @author Fabian Hardt
 */
public interface ItemRepository extends JpaRepository<Item, Long> {

    /**
     * Returns an optional with the item as value or an empty optional, if no category with
     * the given item name could be found.
     *
     * @param itemName name of the searched item
     * @return optional with the item as value or an empty optional
     */
    Optional<Item> findByName(String itemName);

    /**
     * Returns {@code true} if an item with the given name exists; otherwise {@code false}
     *
     * @param itemName name of the item
     * @return {@code true} if an item with the given name exists; otherwise {@code false}
     */
    boolean existsByName(String itemName);

    /**
     * Returns a list of items which are at the specified location.
     * If the list is empty no item is at the location.
     *
     * @param location for which the items are search
     * @return list of items which are at the specified location or an empty list
     */
    List<Item> findByLocation(Location location);

    /**
     * Removes the category from all items that have the category.
     *
     * @param category the category which should be removed from the items
     */
    @Modifying
    @Query("UPDATE Item item SET item.category = null WHERE item.category = :category")
    void removeCategoryFromItems(@Param("category") Category category);

    /**
     * Removes the location from all items that have the location.
     *
     * @param location the location which should be removed from the items
     */
    @Modifying
    @Query("UPDATE Item item SET item.location = null WHERE item.location = :location")
    void removeLocationFromItems(Location location);
}
