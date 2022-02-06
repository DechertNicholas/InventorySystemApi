package com.requiemlabs.inventorysystemapi.part;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * A repository specifically for Parts. Should be derived from.
 * @param <T> The type of part for the Repository, must derive from Part.
 * @param <Id> The number Type for the PartId of the object.
 */
@NoRepositoryBean
public interface PartRepository<T extends Part, Id> extends JpaRepository<T, Id> {
}
