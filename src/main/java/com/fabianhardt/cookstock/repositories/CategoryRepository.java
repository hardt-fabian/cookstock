package com.fabianhardt.cookstock.repositories;

import com.fabianhardt.cookstock.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for the access to the {@link Category}-Entities.
 * <p>
 * This interface extends {@link JpaRepository} and provides basic CRUD-Operations for
 * {@link Category}-Objects.
 * </p>
 *
 * @author Fabian Hardt
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
