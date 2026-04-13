package com.fabianhardt.cookstock.dto.item;

import com.fabianhardt.cookstock.entity.Item;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;
import org.jspecify.annotations.Nullable;

import java.time.LocalDate;

/**
 * Data Transfer Object (DTO) for creating a new {@link Item}.
 * <p>
 * This DTO supports the Builder pattern for flexible object creation.
 * All fields can be set using getters and setters or the Builder.
 * <p>
 * Optional fields can be null. Only 'name' is required.
 * </p>
 *
 * @author Fabian Hardt
 */
@Data
@Builder
public class CreateItemRequest {

    /**
     * Name of this item.
     */
    @NotBlank
    private String name;

    /**
     * Quantity of this item that is currently in stock
     */
    @Positive
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
     * Identifier for the category of this item
     */
    @Nullable
    private Long categoryId;

    /**
     * Identifier for the location of the item
     */
    @Nullable
    private Long locationId;

    /**
     * Default constructor for the builder.
     * It ist private to prohibit the access, because the name is required, so the methode
     * {@link #builder(String)} should be used instead.
     *
     * @return an empty builder
     */
    private static CreateItemRequestBuilder builder() {
        return new CreateItemRequestBuilder();
    }

    /**
     * Constructor for the builder.
     *
     * @param name name of the item
     * @return the new builder
     */
    public static CreateItemRequestBuilder builder(String name) {
        return new CreateItemRequestBuilder().name(name);
    }
}
