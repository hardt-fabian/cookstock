package com.fabianhardt.cookstock.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * A shopping list is a list of {@link ShoppingItem ShoppingItems} which should be purchased.
 * Also, a shopping list is an {@link Entity}. It has an id, name and a flag showing whether this
 * shopping list is the default shopping list.
 * Automatic added shopping items will be added to the default shopping list.
 * The name of a shopping list is unique.
 * For each field a get and set methode is provided.
 *
 * @author Fabian Hardt
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class ShoppingList {
    /**
     * Identifier of this shopping list
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Name of this shopping list.
     * It is required and unique.
     */
    @Column(nullable = false, unique = true)
    private String name;

    /**
     * {@code true} if this shopping list is the default list; otherwise {@code false}
     */
    private boolean defaultList;

    /**
     * Shopping items of this shopping list
     */
    @OneToMany
    private List<ShoppingItem> shoppingItemList;
}
