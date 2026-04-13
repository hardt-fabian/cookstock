package com.fabianhardt.cookstock.dto.category;

import com.fabianhardt.cookstock.entity.Category;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * Data Transfer Object (DTO) of a {@link Category} for response.
 * <p>
 * The field 'name' can be set using getter and setter.
 *
 * @author Fabian Hardt
 */
@Data
public class CategoryResponse {

    /**
     * Identifier of the category
     */
    @NotNull
    private Long id;

    /**
     * Name of the category
     */
    @NotBlank
    private String name;

    /**
     * Icon of this category as Unicode-Emoji
     */
    @Nullable
    private String icon;
}
