package com.fabianhardt.cookstock.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents an item of a {@link ShoppingList} and also an {@link Entity}. A shopping item has an
 * id and name. It could also include a specific quantity and the corresponding unit of
 * measurement and a flag showing whether the item has been purchased or not.
 * For each field a get and set methode is provided.
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
    private Double quantity;

    /**
     * Unit of the quantity of this shopping item
     */
    private String unit;

    /**
     * {@code true} if the item were purchased; otherwise {@code false}
     */
    private boolean purchased;

    /**
     * Shopping list on which this item is listed
     */
    @ManyToOne
    private ShoppingList shoppingList;
}
