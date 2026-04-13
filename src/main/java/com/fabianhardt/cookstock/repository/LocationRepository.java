package com.fabianhardt.cookstock.repository;

import com.fabianhardt.cookstock.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

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

    Optional<Location> findByName(String name);
}
