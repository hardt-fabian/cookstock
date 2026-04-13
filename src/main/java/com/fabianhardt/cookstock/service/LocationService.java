package com.fabianhardt.cookstock.service;

import com.fabianhardt.cookstock.dto.location.LocationResponse;
import com.fabianhardt.cookstock.dto.location.CreateLocationRequest;
import com.fabianhardt.cookstock.entity.Location;
import com.fabianhardt.cookstock.exception.LocationAlreadyExistsException;
import com.fabianhardt.cookstock.exception.LocationNotFoundException;
import com.fabianhardt.cookstock.mapper.LocationMapper;
import com.fabianhardt.cookstock.repository.LocationRepository;
import com.fabianhardt.cookstock.repository.ItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing locations.
 * <p>
 * This class provides business logic for creating, reading and deleting locations. 
 * It acts as an intermediary between the persistence layer {@link LocationRepository}
 * and the presentation layer LocationController.
 * </p>
 *
 * @author Fabian Hardt
 */
@Service
public class LocationService {

    /**
     * Interface to the location repository
     */
    private final LocationRepository locationRepository;

    /**
     * Interface to the item repository
     */
    private final ItemRepository itemRepository;

    /**
     * Helper to map data transfer objects to categories and vice versa
     */
    private final LocationMapper locationMapper;

    /**
     * Constructor
     *
     * @param itemRepository Interface to the item repository
     * @param locationRepository Interface to the location repository
     * @param locationMapper Helper to map data transfer objects to categories and vice versa
     */
    public LocationService(LocationRepository locationRepository, ItemRepository itemRepository,
            LocationMapper locationMapper) {
        this.locationRepository = locationRepository;
        this.itemRepository = itemRepository;
        this.locationMapper = locationMapper;
    }

    /**
     * Returns the newly created location, created by the overhanded data transfer object
     *
     * @param request dto to create a new location
     * @return the newly created location as as {@link LocationResponse}
     * @throws LocationAlreadyExistsException if a location with the given name already exists
     */
    public LocationResponse createLocation(CreateLocationRequest request) {
        String locationName = request.getName();
        Optional<Location> locationByName = this.locationRepository.findByName(locationName);
        if (locationByName.isPresent()) {
            throw new LocationAlreadyExistsException(locationName);
        }

        Location location = this.locationMapper.toEntity(request);
        return this.locationMapper.toDto(this.locationRepository.save(location));
    }

    /**
     * Returns an {@code Optional} with the location as value or an empty {@code Optional}
     * if no location with the specified id exists.
     *
     * @param id the id of the searched location
     * @return {@code Optional} with the location as {@link LocationResponse} or empty {@code
     * Optional}
     */
    public Optional<LocationResponse> getLocationById(Long id) {
        return this.locationRepository.findById(id).map(this.locationMapper::toDto);
    }

    /**
     * Returns all categories.
     *
     * @return all categories as as {@link LocationResponse}
     */
    public List<LocationResponse> getAllLocations() {
        List<Location> categories = this.locationRepository.findAll();
        return this.locationMapper.toDtoList(categories);
    }

    /**
     * Deletes the location with the given id.
     * It also removes the location from all items.
     *
     * @param id the id of the location which should be deleted
     * @throws LocationNotFoundException if no item with the given id exists
     */
    @Transactional
    public void deleteLocation(Long id) {
        Location location = this.locationRepository.findById(id).orElseThrow(
                () -> new LocationNotFoundException(id));
        this.itemRepository.removeLocationFromItems(location);
        this.locationRepository.delete(location);
    }
}
