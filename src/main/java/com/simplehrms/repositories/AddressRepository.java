package com.simplehrms.repositories;

import org.springframework.data.repository.CrudRepository;

import com.simplehrms.entities.Address;

public interface AddressRepository extends CrudRepository<Address, Long>  {

}
