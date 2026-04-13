package com.fabianhardt.cookstock.repository;

import com.fabianhardt.cookstock.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

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

    /**
     *
     *
     * @param name
     * @return
     */
    //TODO JavaDoc
    Optional<Category> findByName(String name);

    boolean existsByName(String categoryByName);
}
