package com.fabianhardt.cookstock.repositories;

import com.fabianhardt.cookstock.entities.Category;
import com.fabianhardt.cookstock.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

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

}
