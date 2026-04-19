package com.fabianhardt.cookstock.mapper;

import com.fabianhardt.cookstock.dto.location.LocationResponse;
import com.fabianhardt.cookstock.entity.Location;
import com.fabianhardt.cookstock.dto.location.CreateLocationRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

/**
 * Helper class to map data transfer objects to locations and vice versa
 *
 * @author Fabian Hardt
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface LocationMapper {

    /**
     * Returns a mapped {@link LocationResponse} for the specified location
     *
     * @param location the location which should be mapped
     * @return a mapped {@link LocationResponse} for the specified location
     */
    LocationResponse toDto(Location location);

    /**
     * Returns a liste of mapped {@link LocationResponse} for the specified locations
     *
     * @param locations the locations which should be mapped
     * @return a liste of mapped {@link LocationResponse} for the specified locations
     */
    List<LocationResponse> toDtoList(List<Location> locations);

    /**
     * Returns the corresponding {@link Location} for the specified create location request
     *
     * @param request request data to create a location
     * @return the corresponding {@link Location} for the specified create location request
     */
    Location toEntity(CreateLocationRequest request);
}
