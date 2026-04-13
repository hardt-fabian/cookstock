package com.fabianhardt.cookstock.mapper;

import com.fabianhardt.cookstock.dto.shoppingItem.ShoppingItemResponse;
import com.fabianhardt.cookstock.dto.shoppingItem.CreateShoppingItemRequest;
import com.fabianhardt.cookstock.entity.ShoppingItem;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ShoppingItemMapper {

    ShoppingItemResponse toDto(ShoppingItem shoppingItem);

    List<ShoppingItemResponse> toDtoList(List<ShoppingItem> shoppingItems);

    ShoppingItem toEntity(CreateShoppingItemRequest request);
}
