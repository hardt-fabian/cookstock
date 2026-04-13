package com.fabianhardt.cookstock.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.UUID;

import java.time.LocalDate;

/**
 * Represents an item {@link Entity}. An item at least has an id and name.
 * It also could have a specific quantity and the corresponding unit of measurement, a date of
 * expiration, a minimale quantity which should be in stock, a {@link Category} and a
 * {@link Location}.
 * The name of an item is unique.
 * For each field, a get and set methode is provided.
 *
 * @author Fabian Hardt
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Item {
    /**
     * Identifier of this item
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Name of this item.
     * It is required and unique.
     */
    @Column(nullable = false, unique = true)
    private String name;

    /**
     * Quantity of this item that is currently in stock
     */
    private Double quantity;

    /**
     * Unit of the item e.g. "g", "ml" or "pcs"
     */
    private String unit;

    /**
     * Date at which the item expires
     */
    private LocalDate expirationDate;

    /**
     * Minimal quantity of this item that should be in stock
     */
    private Double minQuantity;

    /**
     * Category of this item e.g. "meat" or "dairy products"
     */
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    /**
     * Location of the item
     */
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;
}
