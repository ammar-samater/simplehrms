/**
 * 
 */
package com.simplehrms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.simplehrms.entities.Competency;
import com.simplehrms.exceptions.BadRequestException;
import com.simplehrms.repositories.CompetencyRepository;

/**
 * @author Ammar Samater
 *
 */
@RestController
public class CompetenceController {

	@Autowired
	private CompetencyRepository competencyRepository;

	@GetMapping(path = "/competencies")
	public Iterable<Competency> getAllCompetencies() {
		return competencyRepository.findAll();
	}

	@GetMapping(path = "/competencies/{id}")
	public Competency getCompetenceById(@PathVariable Long id) {

		return competencyRepository.findById(id).get();
	}

	@PostMapping(path = "/competencies")
	public String addCompetence(@RequestBody Competency competence) {

		competencyRepository.save(competence);
		return "competencies/" + competence.getId();

	}

	@DeleteMapping(path = "/competencies/{id}")
	public void deleteCompetence(@PathVariable Long id) {

		competencyRepository.deleteById(id);

	}

	@PutMapping(path = "/competencies/{id}")
	public String updateCompetence(@RequestBody Competency competence, @PathVariable Long id) {
		if (competence.getId() == null)
			throw new BadRequestException("competence id must be included to performe update");
		if (competence.getId() != id)
			throw new BadRequestException("competence id in request does not match the competence id in url");

		competence = competencyRepository.save(competence);
		return "/competencies/" + competence.getId();

	}

}
