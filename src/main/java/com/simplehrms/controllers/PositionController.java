package com.simplehrms.controllers;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simplehrms.entities.Position;
import com.simplehrms.exceptions.BadRequestException;
import com.simplehrms.exceptions.GeneralException;
import com.simplehrms.exceptions.ResourceNotFoundException;
import com.simplehrms.repositories.PositionRepository;

/**
 * @author Hussein AlSaber
 *
 */
@Controller
public class PositionController {

	@Autowired
	private PositionRepository positionRepository;


	@GetMapping(path = "/positions")
	public @ResponseBody Iterable<Position> getAllEmployees() {
		try {
			return positionRepository.findAll();
		} catch (Exception e) {
			throw new GeneralException("Internal error");
		}
	}

	@GetMapping(path = "/positions/{id}")
	public @ResponseBody Position getPositionById(@PathVariable Long id) {
		try {
			return positionRepository.findById(id).get();
		} catch (NoSuchElementException e) {
			throw new ResourceNotFoundException("Unable to find a position with id " + id);
		} catch (Exception e) {
			throw new GeneralException("Internal error");
		}
	}

	@PostMapping(path = "/positions")
	public @ResponseBody String addPosition(@RequestBody Position position) {
		try {
			positionRepository.save(position);
			return "positions/" + position.getId();
		} catch (Exception e) {
			if (e instanceof DataIntegrityViolationException) {
				throw new BadRequestException("position not added due to constraint violation");
			} else {
				throw e;
			}
		}
	}

	@DeleteMapping(path = "/positions/{id}")
	public @ResponseBody void deletePosition(@PathVariable Long id) {
		try {
			positionRepository.deleteById(id);
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Unable to find a position with id " + id);
		}

	}

	@PutMapping(path = "/positions/{id}")
	public @ResponseBody String updatePosition(@RequestBody Position position, @PathVariable Long id) {
		if (position.getId() == 0)
			throw new BadRequestException("position id must be included to performe update");
		if (position.getId() != id)
			throw new BadRequestException("position id in request does not match the employee id in url");
		try {
			position = positionRepository.save(position);
			return "/positions/" + position.getId();
		} catch (DataIntegrityViolationException e) {
			throw new BadRequestException("position not updated due to constraint violation");
		}
	}

	@GetMapping(path = "/positions/create")
	public String getAddPositionForm(Model model) {
		model.addAttribute("positions", positionRepository.findAll());
		return "forms/add-position-form";
	}

	@Transactional
	@GetMapping(path = "/positions/{id}/update")
	public String getUpdatePositionForm(@PathVariable Long id, Model model) {
		Position position = positionRepository.findById(id).get();
		model.addAttribute("position", position);
		return "forms/update-position-form";
	}

}

