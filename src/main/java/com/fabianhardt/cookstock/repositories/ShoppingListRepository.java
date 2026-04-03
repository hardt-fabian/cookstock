package com.fabianhardt.cookstock.repositories;

import com.fabianhardt.cookstock.entities.Category;
import com.fabianhardt.cookstock.entities.ShoppingList;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for the access to the {@link ShoppingList}-Entities.
 * <p>
 * This interface extends {@link JpaRepository} and provides basic CRUD-Operations for
 * {@link ShoppingList}-Objects.
 * </p>
 *
 * @author Fabian Hardt
 */
public interface ShoppingListRepository extends JpaRepository<ShoppingList, Long> {}