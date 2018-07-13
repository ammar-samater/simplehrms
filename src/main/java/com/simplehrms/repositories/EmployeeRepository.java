/**
 * 
 */
package com.simplehrms.repositories;

import org.springframework.data.repository.CrudRepository;

import com.simplehrms.entities.Employee;

/**
 * This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
 * CRUD refers Create, Read, Update, Delete
 * 
 * @author Ammar Samater
 *
 */
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}




