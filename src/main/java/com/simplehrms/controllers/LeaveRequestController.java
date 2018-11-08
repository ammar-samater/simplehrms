/**
 * 
 */
package com.simplehrms.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simplehrms.entities.LeaveRequest;
import com.simplehrms.entities.LeaveType;
import com.simplehrms.exceptions.BadRequestException;
import com.simplehrms.exceptions.GeneralException;
import com.simplehrms.exceptions.ResourceNotFoundException;
import com.simplehrms.repositories.LeaveRequestRepository;

/**
 * @author Ammar Samater
 *
 */
@Controller
public class LeaveRequestController {
	
	@Autowired
	private LeaveRequestRepository leaveRequestRepository;
	
	@GetMapping(path = "/leave-requests")
	public @ResponseBody Iterable<LeaveRequest> getAllLeaveRequests() {
		try {
			return leaveRequestRepository.findAll();
		} catch (Exception e) {
			throw new GeneralException("Internal error");
		}
	}
	
	@GetMapping(path = "/employees/{id}/leave-requests")
	public @ResponseBody Iterable<LeaveRequest> getLeaveRequestsByEmployeeId(@PathVariable Long id) {
		try {
			return leaveRequestRepository.findByEmployeeId(id);
		} catch (Exception e) {
			throw new GeneralException("Internal error");
		}
	}
	
	
	
	@GetMapping(path = "/leave-requests/{id}")
	public @ResponseBody LeaveRequest getLeaveRequestById(@PathVariable Long id) {
		try {
			return leaveRequestRepository.findById(id).get();
		} catch (NoSuchElementException e) {
			throw new ResourceNotFoundException("Unable to find a leave request with id " + id);
		} catch (Exception e) {
			throw new GeneralException("Internal error");
		}
	}
	
	@PostMapping(path = "/leave-requests")
	public @ResponseBody String addLeaveRequest(@RequestBody LeaveRequest leaveRequest) {
		try {
			leaveRequestRepository.save(leaveRequest);
			return "leaverequests/" + leaveRequest.getId();
		} catch (Exception e) {
			if (e instanceof DataIntegrityViolationException) {
				throw new BadRequestException("leave request not added due to constraint violation");
			} else {
				throw e;
			}
		}
	}
	
	
	
	
	@GetMapping(path = "/leave-requests/types")
	public @ResponseBody List<LeaveType> getLeaveRequestTypes(){
		return new ArrayList<LeaveType>(Arrays.asList(LeaveType.values()));
	}
	

}
