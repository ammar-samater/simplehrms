/**
 * 
 */
package com.simplehrms.controllers;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.simplehrms.entities.City;
import com.simplehrms.entities.Site;
import com.simplehrms.repositories.CityRepository;
import com.simplehrms.repositories.SiteRepository;

/**
 * @author Ammar Samater
 *
 */
@RestController
public class SiteController {

	@Autowired
	private SiteRepository siteRepository;
	
	@Autowired
	private CityRepository cityRepository;


	@GetMapping(path = "/sites")
	public @ResponseBody Iterable<Site> getAllSites() {
		Iterable<Site> sites = siteRepository.findAll();
		return sites;
	}
	
	

	@PostMapping(path = "/sites")
	public @ResponseBody String addSite(@RequestBody Site site) {
		
		//City city = cityRepository.findById(site.getAddress().getCity().getId()).get(); 
		//site.getAddress().setCity(city);
		site = siteRepository.save(site);
		return site.getId().toString();
	}

}
