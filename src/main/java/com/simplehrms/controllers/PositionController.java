package com.simplehrms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.simplehrms.entities.Position;
import com.simplehrms.exceptions.BadRequestException;
import com.simplehrms.jsonview.View;
import com.simplehrms.repositories.PositionRepository;

/**
 * @author Hussein AlSaber
 * @author Ammar Samater
 */
@RestController
public class PositionController {

	@Autowired
	private PositionRepository positionRepository;

	@JsonView(View.Summary.class)
	@GetMapping(path = "/positions")
	public Iterable<Position> getAllPositions() {
		return positionRepository.findAll();
	}

	
	@GetMapping(path = "/positions/{id}")
	@Transactional
	public Position getPositionById(@PathVariable Long id) {
		Position position = positionRepository.findById(id).get();
		position.getCompetencies().size();
		return position;
	}

	@PostMapping(path = "/positions")
	public String addPosition(@RequestBody Position position) {
		positionRepository.save(position);
		return "positions/" + position.getId();

	}

	@DeleteMapping(path = "/positions/{id}")
	public void deletePosition(@PathVariable Long id) {
		positionRepository.deleteById(id);
	}

	@PutMapping(path = "/positions/{id}")
	public String updatePosition(@RequestBody Position position, @PathVariable Long id) {
		if (position.getId() == null)
			throw new BadRequestException("position id must be included to performe update");
		if (position.getId() != id)
			throw new BadRequestException("position id in request does not match the employee id in url");

		position = positionRepository.save(position);
		return "/positions/" + position.getId();

	}

}
