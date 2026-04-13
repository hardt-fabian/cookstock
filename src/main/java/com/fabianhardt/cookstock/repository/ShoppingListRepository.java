package com.fabianhardt.cookstock.repository;

import com.fabianhardt.cookstock.entity.ShoppingList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repository interface for the access to the {@link ShoppingList}-Entities.
 * <p>
 * This interface extends {@link JpaRepository} and provides basic CRUD-Operations for
 * {@link ShoppingList}-Objects.
 * </p>
 *
 * @author Fabian Hardt
 */
public interface ShoppingListRepository extends JpaRepository<ShoppingList, Long> {

    Optional<ShoppingList> findByName(String shoppingListName);

    boolean existsByName(String shoppingListName);

    boolean existsByDefaultListTrue();
}