package com.requiemlabs.inventorysystemapi.part;

import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface InHouseRepository extends PartRepository<InHouse, Long> {

    // Name is a property of the base class, so the query must be written explicitly
    @Query("SELECT i FROM InHouse i WHERE i.Name = ?1")
    Optional<InHouse> findInHouseByName(String name);
}
