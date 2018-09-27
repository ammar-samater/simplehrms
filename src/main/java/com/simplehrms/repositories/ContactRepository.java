package com.simplehrms.repositories;

import org.springframework.data.repository.CrudRepository;

import com.simplehrms.entities.Contact;;

public interface ContactRepository extends CrudRepository<Contact, Long>  {

}
