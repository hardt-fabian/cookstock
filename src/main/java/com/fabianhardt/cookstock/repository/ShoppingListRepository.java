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

    /**
     * Returns an optional with the shoppingList as value or an empty optional, if no shopping list
     * with the given name could be found.
     *
     * @param shoppingListName name of the searched shopping list
     * @return optional with the shopping list as value or an empty optional
     */
    Optional<ShoppingList> findByName(String shoppingListName);

    /**
     * Returns {@code true} if a shopping list with the given name exists; otherwise {@code false}
     *
     * @param shoppingListName name of the shopping list
     * @return {@code true} if a shopping list with the given name exists; otherwise {@code false}
     */
    boolean existsByName(String shoppingListName);

    /**
     * Returns {@code true} if a default shopping list exists; otherwise {@code false}
     *
     * @return {@code true} if a default shopping list exists; otherwise {@code false}
     */
    boolean existsByDefaultListTrue();
}