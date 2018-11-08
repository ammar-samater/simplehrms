/**
 * 
 */
package com.simplehrms.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.simplehrms.entities.LeaveRequest;

/**
 * This will be AUTO IMPLEMENTED by Spring into a managed bean 
 * CRUD refers Create, Read, Update, Delete
 * 
 * @author Ammar Samater
 *
 */
public interface LeaveRequestRepository extends CrudRepository<LeaveRequest, Long>{
	
	  @Query("select u from LeaveRequest u where u.employee.id = ?1")
	  Iterable<LeaveRequest> findByEmployeeId(Long id);

}
