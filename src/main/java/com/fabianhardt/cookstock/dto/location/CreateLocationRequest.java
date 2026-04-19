package com.fabianhardt.cookstock.dto.location;

import com.fabianhardt.cookstock.entity.Location;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Request data transfer object to create a {@link Location}
 *
 * @author Fabian Hardt
 */
@Data
@AllArgsConstructor
public class CreateLocationRequest {

    /**
     * Name of the location
     */
    @NotBlank
    @NotNull
    private String name;
}