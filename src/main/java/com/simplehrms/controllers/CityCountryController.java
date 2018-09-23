/**
 * 
 */
package com.simplehrms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.simplehrms.entities.City;
import com.simplehrms.entities.Country;
import com.simplehrms.repositories.CityRepository;
import com.simplehrms.repositories.CountryRepository;

/**
 * @author Ammar Samater
 *
 */
@RestController
public class CityCountryController {

	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private CityRepository cityRepository;

	@GetMapping(path = "/countries")
	public @ResponseBody Iterable<Country> getAllCountries() {
		Iterable<Country> countries = countryRepository.findAll();
		return countries;
	}

	@GetMapping(path = "/countries/{countryCode}/cities")
	public @ResponseBody Iterable<City> getAllCities(@PathVariable String countryCode) {
		Iterable<City> cities = cityRepository.findByCountry(new Country(countryCode, null, null));
		return cities;
	}

}
