package com.fabianhardt.cookstock.mapper;

import com.fabianhardt.cookstock.dto.shoppingItem.ShoppingItemResponse;
import com.fabianhardt.cookstock.dto.shoppingList.CreateShoppingListRequest;
import com.fabianhardt.cookstock.dto.shoppingList.ShoppingListResponse;
import com.fabianhardt.cookstock.entity.ShoppingItem;
import com.fabianhardt.cookstock.entity.ShoppingList;
import org.mapstruct.*;

import java.util.List;

/**
 * Helper class to map data transfer objects to shopping lists and vice versa
 *
 * @author Fabian Hardt
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = ShoppingItemMapper.class)
public interface ShoppingListMapper {

    /**
     * Returns a mapped {@link ShoppingListResponse} for the specified shopping list
     *
     * @param shoppingList the shopping list which should be mapped
     * @return a mapped {@link ShoppingListResponse} for the specified shopping list
     */
    ShoppingListResponse toDto(ShoppingList shoppingList);

    /**
     * Returns a liste of mapped {@link ShoppingListResponse} for the specified shopping lists
     *
     * @param shoppingLists the shopping lists which should be mapped
     * @return a liste of mapped {@link ShoppingListResponse} for the specified shopping lists
     */
    List<ShoppingListResponse> toDtoList(List<ShoppingList> shoppingLists);

    /**
     * Returns the corresponding {@link ShoppingList} for the specified create shopping list request
     *
     * @param request request data to create a shopping list
     * @return the corresponding {@link ShoppingList} for the specified create shopping list request
     */
    ShoppingList toEntity(CreateShoppingListRequest request);
}
