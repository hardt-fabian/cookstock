package com.fabianhardt.cookstock.dto.shoppingList;

import com.fabianhardt.cookstock.dto.shoppingItem.ShoppingItemResponse;
import com.fabianhardt.cookstock.entity.Location;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

/**
 * Data Transfer Object (DTO) of a {@link Location} for response.
 * <p>
 * The field 'name' can be set using getter and setter.
 *
 * @author Fabian Hardt
 */
@Data
public class ShoppingListResponse {
    /**
     * Identifier of this shopping list
     */
    @NotNull
    private final Long id;

    /**
     * Name of this shopping list
     */
    @NotBlank
    private final String name;

    /**
     * {@code true} if this shopping list is the default list; otherwise {@code false}
     */
    private final boolean defaultList;

    /**
     * Shopping items of this shopping list
     */
    private final List<ShoppingItemResponse> items;
}