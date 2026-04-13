package com.fabianhardt.cookstock.dto.category;

import com.fabianhardt.cookstock.entity.Category;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * Data Transfer Object (DTO) for creating a new {@link Category}.
 * <p>
 * The field 'name' can be set using getter and setter.
 *
 * @author Fabian Hardt
 */
@Data
public class CreateCategoryRequest {

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
