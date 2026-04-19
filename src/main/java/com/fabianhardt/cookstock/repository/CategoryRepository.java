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
     * Returns an optional with the category as value or an empty optional, if no category with
     * the given name could be found.
     *
     * @param name name of the searched category
     * @return optional with the category as value or an empty optional
     */
    Optional<Category> findByName(String name);

    /**
     * Returns {@code true} if a category with the given name exists; otherwise {@code false}
     *
     * @param categoryName name of the category
     * @return {@code true} if a category with the given name exists; otherwise {@code false}
     */
    boolean existsByName(String categoryName);
}
