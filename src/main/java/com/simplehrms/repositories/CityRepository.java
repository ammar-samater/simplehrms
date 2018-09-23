/**
 * 
 */
package com.simplehrms.repositories;

import org.springframework.data.repository.CrudRepository;

import com.simplehrms.entities.City;
import com.simplehrms.entities.Country;

/**
 * @author Ammar Samater
 *
 */
public interface CityRepository extends CrudRepository<City, Long>{
	
	Iterable<City> findByCountry(Country country);

}
