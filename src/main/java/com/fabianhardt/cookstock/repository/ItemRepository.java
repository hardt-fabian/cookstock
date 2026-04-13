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

    Optional<Item> findByName(String name);

    List<Item> findByLocation(Location location);

    @Modifying
    @Query("UPDATE Item item SET item.category = null WHERE item.category = :category")
    void removeCategoryFromItems(@Param("category") Category category);

    @Modifying
    @Query("UPDATE Item item SET item.location = null WHERE item.location = :location")
    void removeLocationFromItems(Location location);
}
