package com.fabianhardt.cookstock.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

/**
 * Represents a location {@link Entity}. A location has an id and name. The name of a location is
 * unique.
 * For each field, a get and set methode is provided.
 *
 * @author Fabian Hardt
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Location {
    /**
     * Identifier of this location
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Name of this location e.g. "kitchen" or "basement".
     * It is required and unique.
     */
    @Column(nullable = false, unique = true)
    private String name;

    /**
     * Items which are at this location
     */
    @OneToMany(mappedBy = "location")
    private Set<Item> items;
}
