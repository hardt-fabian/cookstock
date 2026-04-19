package com.fabianhardt.cookstock.dto.item;

import com.fabianhardt.cookstock.entity.Item;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;
import org.jspecify.annotations.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;

import java.time.LocalDate;

/**
 * Data Transfer Object (DTO) to update an {@link Item}.
 *
 * <p>
 * This DTO supports the Builder pattern for flexible object creation.
 * All fields can be set using getters and setters or the Builder.
 * <p>
 * All fields are optional. If the field is 'empty' there is no update for
 * the field.
 * </p>
 *
 * @author Fabian Hardt
 */
@Data
@Builder
public class UpdateItemRequest {
    /**
     * Name of this item.
     */
    private JsonNullable<@NotBlank String> name;

    /**
     * Quantity of this item that is currently in stock
     */
    private JsonNullable<@Positive Double> quantity;

    /**
     * Unit of the item e.g. "g", "ml" or "pcs"
     */
    private JsonNullable<@Nullable String> unit;

    /**
     * Date at which the item expires
     */
    private JsonNullable<@Nullable LocalDate> expirationDate;

    /**
     * Minimal quantity of this item that should be in stock
     */
    private JsonNullable<@Positive Double> minQuantity;

    /**
     * Identifier for the category of this item
     */
    private JsonNullable<@Nullable Long> categoryId;

    /**
     * Identifier for the location of the item
     */
    private JsonNullable<@Nullable Long> locationId;
}
