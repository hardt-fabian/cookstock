package com.fabianhardt.cookstock.dto.location;

import com.fabianhardt.cookstock.entity.Category;
import com.fabianhardt.cookstock.entity.Location;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * Data Transfer Object (DTO) of a {@link Location} for response.
 * <p>
 * The field 'name' can be set using getter and setter.
 *
 * @author Fabian Hardt
 */
@Data
public class LocationResponse {

    /**
     * Identifier of this location
     */
    @NotNull
    private Long id;

    /**
     * Name of this location
     */
    @NotBlank
    private String name;


}
