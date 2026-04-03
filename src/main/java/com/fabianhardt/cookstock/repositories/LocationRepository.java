package com.fabianhardt.cookstock.repositories;

import com.fabianhardt.cookstock.entities.Category;
import com.fabianhardt.cookstock.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for the access to the {@link Location}-Entities.
 * <p>
 * This interface extends {@link JpaRepository} and provides basic CRUD-Operations for
 * {@link Location}-Objects.
 * </p>
 *
 * @author Fabian Hardt
 */
public interface LocationRepository extends JpaRepository<Location, Long> {

}
