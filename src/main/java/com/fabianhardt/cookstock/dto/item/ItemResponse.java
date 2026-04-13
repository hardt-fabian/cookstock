package com.fabianhardt.cookstock.dto.item;

import com.fabianhardt.cookstock.dto.location.LocationResponse;
import com.fabianhardt.cookstock.entity.Item;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.jspecify.annotations.Nullable;

import java.time.LocalDate;

/**
 * Data Transfer Object (DTO) of an {@link Item}.
 * <p>
 * This DTO supports the Builder pattern for flexible object creation.
 * All fields can be set using getters and setters or the Builder.
 * <p>
 * Optional fields can be null. The fields 'id' and 'name' are required.
 * </p>
 *
 * @author Fabian Hardt
 */
@Data
@Builder
public class ItemResponse {
    /**
     * Identifier of this item
     */
    @NotNull
    private Long id;

    /**
     * Name of this item.
     * It is required and unique.
     */
    @NotBlank
    private String name;

    /**
     * Quantity of this item that is currently in stock
     */
    @Nullable
    private Double quantity;

    /**
     * Unit of the item e.g. "g", "ml" or "pcs"
     */
    @Nullable
    private String unit;

    /**
     * Date at which the item expires
     */
    @Nullable
    private LocalDate expirationDate;

    /**
     * Minimal quantity of this item that should be in stock
     */
    @Nullable
    private Double minQuantity;

    /**
     * Name of the category of this item e.g. "meat" or "dairy products"
     */
    @Nullable
    private String categoryName;

    /**
     * Data transfer object of the location of this item
     */
    @Nullable
    private LocationResponse locationResponse;
}
