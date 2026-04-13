package com.fabianhardt.cookstock.dto.shoppingList;

import com.fabianhardt.cookstock.dto.shoppingItem.ShoppingItemResponse;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class ShoppingListResponse {

    @NotNull
    private final Long id;

    @NotBlank
    private final String name;

    private final boolean defaultList;

    private final List<ShoppingItemResponse> items;
}