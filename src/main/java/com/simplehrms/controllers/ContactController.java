package com.simplehrms.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.simplehrms.entities.Contact;
import com.simplehrms.repositories.ContactRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


@RestController
public class ContactController {

	@Autowired
	private ContactRepository contactRepository;
	

	@GetMapping(path = "/contacts")
	public @ResponseBody Iterable<Contact> getAllContacts() {
		return contactRepository.findAll();
	}
	
	@GetMapping(path = "/contacts/{id}")
	public @ResponseBody Contact getContactById(@PathVariable Long id) {
		return contactRepository.findById(id).get();
	}

	@PostMapping(path = "/contacts")
	public @ResponseBody String addContact(@RequestBody Contact contact) {
		contactRepository.save(contact);
		return "contacts/" + contact.getContactId();
	}

	@DeleteMapping(path = "/contacts/{id}")
	public @ResponseBody void deleteContact(@PathVariable Long id) {
		contactRepository.deleteById(id);
		
	}
	
	@PutMapping(path = "/contacts/{id}")
	public @ResponseBody String updateContact(@RequestBody Contact contact, @PathVariable Long id) {
		contactRepository.save(contact);
		return "/contacts/" +contact.getContactId();
	}
	
}
