package com.fabianhardt.cookstock.dto.shoppingItem;


import com.fabianhardt.cookstock.entity.ShoppingItem;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;


/**
 * Data Transfer Object (DTO) of an {@link ShoppingItem}.
 * <p>
 * This DTO supports the Builder pattern for flexible object creation.
 * All fields can be set using getters and setters or the Builder.
 * <p>
 * Optional fields can be null. The fields 'id', 'name' and 'purchased' are required.
 * </p>
 *
 * @author Fabian Hardt
 */
@Data
@Builder
public class ShoppingItemResponse {
    /**
     * Identifier of this shopping item
     */
    @NotNull
    private Long id;

    /**
     * Name of this shopping item.
     * It is required.
     */
    @NotBlank
    private String name;

    /**
     * Quantity of this shopping item
     */
    @Nullable
    private Double quantity;

    /**
     * Unit of the quantity of this shopping item
     */
    @Nullable
    private String unit;

    /**
     * {@code true} if the shopping item were purchased; otherwise {@code false}
     */
    private boolean purchased;

    /**
     * Name of the category of this item e.g. "meat" or "dairy products"
     */
    @Nullable
    private String categoryName;
}
