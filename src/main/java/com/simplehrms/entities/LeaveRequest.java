/**
 * 
 */
package com.simplehrms.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Ammar Samater
 *
 */
@Entity
@Table(name = "Leave_Requests")
@NamedQuery(name = "LeaveRequest.findAll", query = "SELECT e FROM LeaveRequest e")
public class LeaveRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private Long id;

	@ManyToOne(optional = false)
	@JoinColumn(name = "emp_id", nullable = false, updatable = false)
	private Employee employee;

	@Enumerated(EnumType.STRING)
	private LeaveType type;

	@Temporal(TemporalType.DATE)
	@Column(name = "start_date")
	private Date startDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "end_date")
	private Date endDate;

	private String comment;

	@Enumerated(EnumType.STRING)
	private LeaveStatus status;

	/**
	 * 
	 */
	public LeaveRequest() {
		super();
	}

	/**
	 * @param id
	 * @param employee
	 * @param type
	 * @param startDate
	 * @param endDate
	 * @param comment
	 * @param status
	 */
	public LeaveRequest(Long id, Employee employee, LeaveType type, Date startDate, Date endDate, String comment,
			LeaveStatus status) {
		this.id = id;
		this.employee = employee;
		this.type = type;
		this.startDate = startDate;
		this.endDate = endDate;
		this.comment = comment;
		this.status = status;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the employee
	 */
	public Employee getEmployee() {
		return employee;
	}

	/**
	 * @param employee
	 *            the employee to set
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	/**
	 * @return the type
	 */
	public LeaveType getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(LeaveType type) {
		this.type = type;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate
	 *            the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate
	 *            the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment
	 *            the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * @return the status
	 */
	public LeaveStatus getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(LeaveStatus status) {
		this.status = status;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LeaveRequest other = (LeaveRequest) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LeaveRequest [id=" + id + ", employeeId=" + employee.getId() + ", type=" + type + ", startDate="
				+ startDate + ", endDate=" + endDate + ", comment=" + comment + ", status=" + status + "]";
	}

}
