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
    @Query("SELECT i FROM InHouse i WHERE i.Name = ?1")
    Optional<InHouse> findInHouseByName(String name);
}
