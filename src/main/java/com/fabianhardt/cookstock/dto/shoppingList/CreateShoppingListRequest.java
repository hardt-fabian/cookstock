package com.fabianhardt.cookstock.dto.shoppingList;

import com.fabianhardt.cookstock.dto.shoppingItem.CreateShoppingItemRequest;
import com.fabianhardt.cookstock.entity.ShoppingList;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

/**
 * Request data transfer object to create a {@link ShoppingList}
 *
 * @author Fabian Hardt
 */
@Data
public class CreateShoppingListRequest {
    /**
     * Name of the shopping list
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
    @Nullable
    private final List<CreateShoppingItemRequest> shoppingItems;
}