package com.fabianhardt.cookstock.mapper;

import com.fabianhardt.cookstock.dto.shoppingItem.ShoppingItemResponse;
import com.fabianhardt.cookstock.dto.shoppingItem.CreateShoppingItemRequest;
import com.fabianhardt.cookstock.entity.ShoppingItem;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

/**
 * Helper class to map data transfer objects to shopping items and vice versa
 *
 * @author Fabian Hardt
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ShoppingItemMapper {

    /**
     * Returns a mapped {@link ShoppingItemResponse} for the specified shopping item
     *
     * @param shoppingItem the shopping item which should be mapped
     * @return a mapped {@link ShoppingItemResponse} for the specified shopping item
     */
    ShoppingItemResponse toDto(ShoppingItem shoppingItem);

    /**
     * Returns a liste of mapped {@link ShoppingItemResponse} for the specified shopping items
     *
     * @param shoppingItems the shopping items which should be mapped
     * @return a liste of mapped {@link ShoppingItemResponse} for the specified shopping items
     */
    List<ShoppingItemResponse> toDtoList(List<ShoppingItem> shoppingItems);

    /**
     * Returns the corresponding {@link ShoppingItem} for the specified create shopping item request
     *
     * @param request request data to create a shopping item
     * @return the corresponding {@link ShoppingItem} for the specified create shopping item request
     */
    ShoppingItem toEntity(CreateShoppingItemRequest request);
}
