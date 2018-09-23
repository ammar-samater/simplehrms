/**
 * 
 */
package com.simplehrms.repositories;

import org.springframework.data.repository.CrudRepository;

import com.simplehrms.entities.Department;

/**
 * @author Ammar Samater
 *
 */
public interface DepartmentRepository extends CrudRepository<Department, Long> {

}
