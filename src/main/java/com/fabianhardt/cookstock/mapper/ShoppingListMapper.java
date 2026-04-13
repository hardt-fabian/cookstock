package com.fabianhardt.cookstock.mapper;

import com.fabianhardt.cookstock.dto.shoppingList.CreateShoppingListRequest;
import com.fabianhardt.cookstock.dto.shoppingList.ShoppingListResponse;
import com.fabianhardt.cookstock.entity.ShoppingList;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = ShoppingItemMapper.class)
public interface ShoppingListMapper {

    ShoppingListResponse toDto(ShoppingList shoppingList);

    List<ShoppingListResponse> toDtoList(List<ShoppingList> shoppingLists);

    ShoppingList toEntity(CreateShoppingListRequest request);
}
