package com.fabianhardt.cookstock.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents a category {@link Entity}. A category has an id and name.
 * The name of a category is unique.
 * For each field, a get and set methode is provided.
 *
 * @author Fabian Hardt
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Category {
    /**
     * Identifier of this category
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Name of this category
     */
    @Column(nullable = false, unique = true)
    private String name;

    /**
     * Icon of this category as Unicode-Emoji
     */
    @Nullable
    private String icon;
}
