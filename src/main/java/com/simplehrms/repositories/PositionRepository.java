/**
 * 
 */
package com.simplehrms.repositories;

import org.springframework.data.repository.CrudRepository;

import com.simplehrms.entities.Position;

/**
 * This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
 * CRUD refers Create, Read, Update, Delete
 * 
 * @author Hussein AlSaber
 *
 */
public interface PositionRepository extends CrudRepository<Position, Long> {

}




