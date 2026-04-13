package com.fabianhardt.cookstock.dto.shoppingItem;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;
import org.jspecify.annotations.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;

@Data
@Builder
public class UpdateShoppingItemRequest {
    /**
     * Quantity of this shopping item or null
     */
    private JsonNullable<@Positive Double> quantity;

    /**
     * Unit of the shopping item e.g. "g", "ml" or "pcs"
     */
    private JsonNullable<@Nullable String> unit;

    /**
     * {@code true} if this shopping item has been purchased; otherwise {@code true}
     */
    private JsonNullable<@NotNull Boolean> purchased;

    /**
     * Identifier for the category of this item
     */
    private JsonNullable<@Nullable Long> categoryId;

    /**
     * Identifier for the shopping list of this shopping item
     */
    private JsonNullable<@Nullable Long> shoppingListId;
}