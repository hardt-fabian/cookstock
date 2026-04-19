package com.fabianhardt.cookstock.mapper;

import com.fabianhardt.cookstock.dto.item.CreateItemRequest;
import com.fabianhardt.cookstock.dto.item.ItemResponse;
import com.fabianhardt.cookstock.entity.Item;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

/**
 * Helper class to map data transfer objects to items and vice versa
 *
 * @author Fabian Hardt
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {CategoryMapper.class, LocationMapper.class})
public interface ItemMapper {

    /**
     * Returns a mapped {@link ItemResponse} for the specified item
     *
     * @param item the item which should be mapped
     * @return a mapped {@link ItemResponse} for the specified item
     */
    ItemResponse toDto(Item item);

    /**
     * Returns a liste of mapped {@link ItemResponse} for the specified items
     *
     * @param items the items which should be mapped
     * @return a liste of mapped {@link ItemResponse} for the specified items
     */
    List<ItemResponse> toDtoList(List<Item> items);

    /**
     * Returns the corresponding {@link Item} for the specified create Item request
     *
     * @param request request data to create a Item
     * @return the corresponding {@link Item} for the specified create Item request
     */
    Item toEntity(CreateItemRequest request);
}
