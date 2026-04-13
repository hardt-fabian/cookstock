package com.fabianhardt.cookstock.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents an item of a {@link ShoppingList} and also an {@link Entity}. A shopping item has an
 * id and name. It could also include a specific quantity and the corresponding unit of
 * measurement and a flag showing whether the item has been purchased or not.
 * For each field, a get and set methode is provided.
 *
 * @author Fabian Hardt
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class ShoppingItem {
    /**
     * Identifier of this shopping item
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Name of this shopping item.
     * It is required.
     */
    @Column(nullable = false)
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
     * Category of this shopping item e.g. "meat" or "dairy products"
     */
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    /**
     * Shopping list on which this shopping item is listed
     */
    @ManyToOne
    @JoinColumn(name = "shoppingList_id", nullable = false)
    private ShoppingList shoppingList;
}
