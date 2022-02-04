package com.requiemlabs.inventorysystemapi.part;

import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface OutsourcedRepository extends PartRepository<Outsourced, Long> {

    // Name is a property of the base class, so the query must be written explicitly
    @Query("SELECT i FROM Outsourced i WHERE i.Name = ?1")
    Optional<Outsourced> findOutsourcedByName(String name);
}
