package com.requiemlabs.inventorysystemapi.part;

import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

/**
 * A repository specifically for InHouse parts.
 */
public interface InHouseRepository extends PartRepository<InHouse, Long> {

    // Name is a property of the base class, so the query must be written explicitly

    /**
     * Finds an InHouse part by Name.
     * @param name The Name to search for.
     * @return An InHouse part with the given Name, if one exists.
     */
    @Query("SELECT CASE WHEN COUNT (p) > 0 THEN TRUE ELSE FALSE END FROM InHouse p WHERE p.Name =?1")
    boolean findInHouseByName(String name);
}
