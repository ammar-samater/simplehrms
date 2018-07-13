/**
 * 
 */
package com.simplehrms.repositories;

import org.springframework.data.repository.CrudRepository;

import com.simplehrms.entities.Country;

/**
 * @author Ammar Samater
 *
 */
public interface CountryRepository extends CrudRepository<Country, String> {

}
