package com.fabianhardt.cookstock.mapper;

import com.fabianhardt.cookstock.entity.Location;
import com.fabianhardt.cookstock.dto.location.CreateLocationRequest;
import com.fabianhardt.cookstock.dto.location.LocationResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

//TODO JavaDoc
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface LocationMapper {

    LocationResponse toDto(Location location);

    List<LocationResponse> toDtoList(List<Location> items);

    Location toEntity(CreateLocationRequest request);
}
