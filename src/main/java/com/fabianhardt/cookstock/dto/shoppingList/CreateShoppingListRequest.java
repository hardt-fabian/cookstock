package com.fabianhardt.cookstock.dto.shoppingList;

import com.fabianhardt.cookstock.dto.shoppingItem.CreateShoppingItemRequest;
import com.fabianhardt.cookstock.entity.ShoppingItem;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
public class CreateShoppingListRequest {
    @NotBlank
    private final String name;

    private final boolean defaultList;

    private final List<CreateShoppingItemRequest> shoppingItems;
}