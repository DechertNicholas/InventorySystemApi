package com.requiemlabs.inventorysystemapi.part;

import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

/**
 * A repository specifically for Outsourced parts.
 */
public interface OutsourcedRepository extends PartRepository<Outsourced, Long> {

    // Name is a property of the base class, so the query must be written explicitly

    /**
     * Finds an Outsourced part by Name.
     * @param name The Name to search for.
     * @return An Outsourced part with the given Name, if one exists.
     */
    @Query("SELECT CASE WHEN COUNT (p) > 0 THEN TRUE ELSE FALSE END FROM Outsourced p WHERE p.Name =?1")
    boolean findOutsourcedByName(String name);
}
