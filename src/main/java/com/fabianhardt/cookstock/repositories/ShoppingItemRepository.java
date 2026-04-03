package com.fabianhardt.cookstock.repositories;

import com.fabianhardt.cookstock.entities.Category;
import com.fabianhardt.cookstock.entities.ShoppingItem;
import org.springframework.data.jpa.repository.JpaRepository;

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

}