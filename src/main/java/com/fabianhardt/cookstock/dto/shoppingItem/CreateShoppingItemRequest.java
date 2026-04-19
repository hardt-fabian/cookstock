package com.fabianhardt.cookstock.dto.shoppingItem;

import com.fabianhardt.cookstock.entity.ShoppingItem;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;
import org.jspecify.annotations.Nullable;

/**
 * Data Transfer Object (DTO) for creating a new {@link ShoppingItem}.
 * <p>
 * This DTO supports the Builder pattern for flexible object creation.
 * All fields can be set using getters and setters or the Builder.
 * <p>
 * Optional fields can be null.
 * </p>
 *
 * @author Fabian Hardt
 */
@Data
@Builder
public class CreateShoppingItemRequest {
    /**
     * Name of this shopping item.
     */
    @NotBlank
    private final String name;

    /**
     * Quantity of this shopping item
     */
    @Positive
    @Nullable
    private Double quantity;

    /**
     * Unit of the shopping item e.g. "g", "ml" or "pcs"
     */
    @Nullable
    private String unit;

    /**
     * {@code true} if this shopping item has been purchased; otherwise {@code true}
     */
    private boolean purchased;

    /**
     * Identifier for the category of this shopping item
     */
    @Nullable
    private Long categoryId;

    /**
     * Identifier for the shopping list of this shopping item
     */
    @NotNull
    private Long shoppingListId;
}