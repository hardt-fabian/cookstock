package com.fabianhardt.cookstock.mapper;

import com.fabianhardt.cookstock.entity.Item;
import com.fabianhardt.cookstock.dto.item.CreateItemRequest;
import com.fabianhardt.cookstock.dto.item.ItemResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

//TODO JavaDoc
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {CategoryMapper.class, LocationMapper.class})
public interface ItemMapper {

    ItemResponse toDto(Item item);

    List<ItemResponse> toDtoList(List<Item> items);

    Item toEntity(CreateItemRequest request);
}
