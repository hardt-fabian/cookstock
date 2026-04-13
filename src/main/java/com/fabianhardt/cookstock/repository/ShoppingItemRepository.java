package com.fabianhardt.cookstock.repository;

import com.fabianhardt.cookstock.entity.Category;
import com.fabianhardt.cookstock.entity.ShoppingItem;
import com.fabianhardt.cookstock.entity.ShoppingList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Repository interface for the access to the {@link ShoppingItem}-Entities.
 * <p>
 * This interface extends {@link JpaRepository} and provides basic CRUD-Operations for
 * {@link ShoppingItem}-Objects.
 * </p>
 *
 * @author Fabian Hardt
 */
public interface ShoppingItemRepository extends JpaRepository<ShoppingItem, Long> {

    void deleteAllByShoppingList(ShoppingList shoppingList);

    @Modifying
    @Query("UPDATE ShoppingItem shoppingItem SET shoppingItem.category = null " +
           "WHERE shoppingItem.category = :category")
    void removeCategoryFromShoppingItems(@Param("category") Category category);
}