package com.simplehrms.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * The persistent class for the employee_position database table.
 * 
 * @author Ammar Samater
 * @author
 */
@Entity
@Table(name = "employee_position")
@NamedQuery(name = "EmployeePosition.findAll", query = "SELECT e FROM EmployeePosition e")
public class EmployeePosition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private Long id;

	@Column(name = "pcn", unique = true)
	private String positionControlNumber;

	@Temporal(TemporalType.DATE)
	@Column(name = "start_date")
	private Date startDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "end_date")
	private Date endDate;

	@Column(name = "commission_pct")
	private BigDecimal commissionPct;

	private BigDecimal salary;

	@ManyToOne
	@JoinColumn(name = "manager_id")
	private Employee manager;

	@ManyToOne
	@JoinColumn(name = "position_id")
	private Position position;

	@Column(name = "paid_days")
	private int annualPaidVacationDays;

	@Column(name = "sick_days")
	private int annualSickVacationDays;

	@Column(name = "emergency_days")
	private int annualEmergencyVacationDays;

	@Column(name = "unpaid_days")
	private int annualUnpaidVacationDays;

	/**
	 * 
	 */
	public EmployeePosition() {
		super();
	}

	/**
	 * @param id
	 * @param positionControlNumber
	 * @param startDate
	 * @param endDate
	 * @param commissionPct
	 * @param salary
	 * @param manager
	 * @param position
	 * @param annualPaidVacationDays
	 * @param annualSickVacationDays
	 * @param annualEmergencyVacationDays
	 * @param annualUnpaidVacationDays
	 */
	public EmployeePosition(Long id, String positionControlNumber, Date startDate, Date endDate,
			BigDecimal commissionPct, BigDecimal salary, Employee manager, Position position,
			int annualPaidVacationDays, int annualSickVacationDays, int annualEmergencyVacationDays,
			int annualUnpaidVacationDays) {
		this.id = id;
		this.positionControlNumber = positionControlNumber;
		this.startDate = startDate;
		this.endDate = endDate;
		this.commissionPct = commissionPct;
		this.salary = salary;
		this.manager = manager;
		this.position = position;
		this.annualPaidVacationDays = annualPaidVacationDays;
		this.annualSickVacationDays = annualSickVacationDays;
		this.annualEmergencyVacationDays = annualEmergencyVacationDays;
		this.annualUnpaidVacationDays = annualUnpaidVacationDays;
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
	 * @return the positionControlNumber
	 */
	public String getPositionControlNumber() {
		return positionControlNumber;
	}

	/**
	 * @param positionControlNumber
	 *            the positionControlNumber to set
	 */
	public void setPositionControlNumber(String positionControlNumber) {
		this.positionControlNumber = positionControlNumber;
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
	 * @return the commissionPct
	 */
	public BigDecimal getCommissionPct() {
		return commissionPct;
	}

	/**
	 * @param commissionPct
	 *            the commissionPct to set
	 */
	public void setCommissionPct(BigDecimal commissionPct) {
		this.commissionPct = commissionPct;
	}

	/**
	 * @return the salary
	 */
	public BigDecimal getSalary() {
		return salary;
	}

	/**
	 * @param salary
	 *            the salary to set
	 */
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	/**
	 * @return the manager
	 */
	public Employee getManager() {
		return manager;
	}

	/**
	 * @param manager
	 *            the manager to set
	 */
	public void setManager(Employee manager) {
		this.manager = manager;
	}

	/**
	 * @return the position
	 */
	public Position getPosition() {
		return position;
	}

	/**
	 * @param position
	 *            the position to set
	 */
	public void setPosition(Position position) {
		this.position = position;
	}

	/**
	 * @return the annualPaidVacationDays
	 */
	public int getAnnualPaidVacationDays() {
		return annualPaidVacationDays;
	}

	/**
	 * @param annualPaidVacationDays
	 *            the annualPaidVacationDays to set
	 */
	public void setAnnualPaidVacationDays(int annualPaidVacationDays) {
		this.annualPaidVacationDays = annualPaidVacationDays;
	}

	/**
	 * @return the annualSickVacationDays
	 */
	public int getAnnualSickVacationDays() {
		return annualSickVacationDays;
	}

	/**
	 * @param annualSickVacationDays
	 *            the annualSickVacationDays to set
	 */
	public void setAnnualSickVacationDays(int annualSickVacationDays) {
		this.annualSickVacationDays = annualSickVacationDays;
	}

	/**
	 * @return the annualEmergencyVacationDays
	 */
	public int getAnnualEmergencyVacationDays() {
		return annualEmergencyVacationDays;
	}

	/**
	 * @param annualEmergencyVacationDays
	 *            the annualEmergencyVacationDays to set
	 */
	public void setAnnualEmergencyVacationDays(int annualEmergencyVacationDays) {
		this.annualEmergencyVacationDays = annualEmergencyVacationDays;
	}

	/**
	 * @return the annualUnpaidVacationDays
	 */
	public int getAnnualUnpaidVacationDays() {
		return annualUnpaidVacationDays;
	}

	/**
	 * @param annualUnpaidVacationDays
	 *            the annualUnpaidVacationDays to set
	 */
	public void setAnnualUnpaidVacationDays(int annualUnpaidVacationDays) {
		this.annualUnpaidVacationDays = annualUnpaidVacationDays;
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
		EmployeePosition other = (EmployeePosition) obj;
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
		return "EmployeePosition [id=" + id + ", positionControlNumber=" + positionControlNumber + ", startDate="
				+ startDate + ", endDate=" + endDate + ", commissionPct=" + commissionPct + ", salary=" + salary
				+ ", manager=" + manager + ", position=" + position + "]";
	}

}