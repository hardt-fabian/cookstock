package com.fabianhardt.cookstock.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

/**
 * Represents a category {@link Entity}. A category has an id and name.
 * The name of a category is unique.
 * For each field a get and set methode is provided.
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
     * Items which are part of this category
     */
    @OneToMany
    @JoinColumn(name = "item_id")
    private Set<Item> items;
}
