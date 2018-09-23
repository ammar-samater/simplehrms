package com.simplehrms.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the employee database table.
 * 
 * 
 * @author Ammar Samater
 * @author
 */
@Entity
@Table(name = "employee")
@NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private Long id;

	@Column(name = "employee_Number", unique = true)
	private String employeeNumber;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "mid_name")
	private String midName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "first_name_lang2")
	private String firstNameLang2;

	@Column(name = "mid_name_lang2")
	private String midNameLang2;

	@Column(name = "last_name_lang2")
	private String lastNameLang2;

	@Column(name = "preferred_name")
	private String preferredName;

	@Column(name = "preferred_name_lang2")
	private String preferredNameLang2;

	@Temporal(TemporalType.DATE)
	private Date dob;

	@Column
	private String gender;

	@Temporal(TemporalType.DATE)
	@Column(name = "hire_date")
	private Date hireDate;

	@Column(name = "martial_status")
	private String martialStatus;

	private String religion;

	private String religionLang2;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "employee_id")
	private List<EmployeePosition> employeePositions;



	public Employee() {
	}

	/**
	 * @param employeeNumber
	 * @param firstName
	 * @param midName
	 * @param lastName
	 * @param firstNameLang2
	 * @param midNameLang2
	 * @param lastNameLang2
	 * @param preferredName
	 * @param preferredNameLang2
	 * @param dob
	 * @param gender
	 * @param hireDate
	 * @param martialStatus
	 * @param religion
	 * @param religionLang2
	 */
	public Employee(String employeeNumber, String firstName, String midName, String lastName, String firstNameLang2,
			String midNameLang2, String lastNameLang2, String preferredName, String preferredNameLang2, Date dob,
			String gender, Date hireDate, String martialStatus, String religion, String religionLang2) {
		this.employeeNumber = employeeNumber;
		this.firstName = firstName;
		this.midName = midName;
		this.lastName = lastName;
		this.firstNameLang2 = firstNameLang2;
		this.midNameLang2 = midNameLang2;
		this.lastNameLang2 = lastNameLang2;
		this.preferredName = preferredName;
		this.preferredNameLang2 = preferredNameLang2;
		this.dob = dob;
		this.gender = gender;
		this.hireDate = hireDate;
		this.martialStatus = martialStatus;
		this.religion = religion;
		this.religionLang2 = religionLang2;
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
	 * @return the employeeNumber
	 */
	public String getEmployeeNumber() {
		return employeeNumber;
	}

	/**
	 * @param employeeNumber
	 *            the employeeNumber to set
	 */
	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the midName
	 */
	public String getMidName() {
		return midName;
	}

	/**
	 * @param midName
	 *            the midName to set
	 */
	public void setMidName(String midName) {
		this.midName = midName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the firstNameLang2
	 */
	public String getFirstNameLang2() {
		return firstNameLang2;
	}

	/**
	 * @param firstNameLang2
	 *            the firstNameLang2 to set
	 */
	public void setFirstNameLang2(String firstNameLang2) {
		this.firstNameLang2 = firstNameLang2;
	}

	/**
	 * @return the midNameLang2
	 */
	public String getMidNameLang2() {
		return midNameLang2;
	}

	/**
	 * @param midNameLang2
	 *            the midNameLang2 to set
	 */
	public void setMidNameLang2(String midNameLang2) {
		this.midNameLang2 = midNameLang2;
	}

	/**
	 * @return the lastNameLang2
	 */
	public String getLastNameLang2() {
		return lastNameLang2;
	}

	/**
	 * @param lastNameLang2
	 *            the lastNameLang2 to set
	 */
	public void setLastNameLang2(String lastNameLang2) {
		this.lastNameLang2 = lastNameLang2;
	}

	/**
	 * @return the preferredName
	 */
	public String getPreferredName() {
		return preferredName;
	}

	/**
	 * @param preferredName
	 *            the preferredName to set
	 */
	public void setPreferredName(String preferredName) {
		this.preferredName = preferredName;
	}

	/**
	 * @return the preferredNameLang2
	 */
	public String getPreferredNameLang2() {
		return preferredNameLang2;
	}

	/**
	 * @param preferredNameLang2
	 *            the preferredNameLang2 to set
	 */
	public void setPreferredNameLang2(String preferredNameLang2) {
		this.preferredNameLang2 = preferredNameLang2;
	}

	/**
	 * @return the dob
	 */
	public Date getDob() {
		return dob;
	}

	/**
	 * @param dob
	 *            the dob to set
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the hireDate
	 */
	public Date getHireDate() {
		return hireDate;
	}

	/**
	 * @param hireDate
	 *            the hireDate to set
	 */
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	/**
	 * @return the martialStatus
	 */
	public String getMartialStatus() {
		return martialStatus;
	}

	/**
	 * @param martialStatus
	 *            the martialStatus to set
	 */
	public void setMartialStatus(String martialStatus) {
		this.martialStatus = martialStatus;
	}

	/**
	 * @return the religion
	 */
	public String getReligion() {
		return religion;
	}

	/**
	 * @param religion
	 *            the religion to set
	 */
	public void setReligion(String religion) {
		this.religion = religion;
	}

	/**
	 * @return the religionLang2
	 */
	public String getReligionLang2() {
		return religionLang2;
	}

	/**
	 * @param religionLang2
	 *            the religionLang2 to set
	 */
	public void setReligionLang2(String religionLang2) {
		this.religionLang2 = religionLang2;
	}

	/**
	 * @return the employeePositions
	 */
	public List<EmployeePosition> getEmployeePositions() {
		return employeePositions;
	}

	/**
	 * @param employeePositions
	 *            the employeePositions to set
	 */
	public void setEmployeePositions(List<EmployeePosition> employeePositions) {
		this.employeePositions = employeePositions;
	}

	/**
	 * Method to add an employee position
	 * 
	 * @param employeePosition
	 * @return the added employee position 
	 */
	public EmployeePosition addEmployeePosition(EmployeePosition employeePosition) {
		getEmployeePositions().add(employeePosition);

		return employeePosition;
	}

	/**
	 * Method to remove an employee position
	 * 
	 * @param employeePosition
	 * @return the removed employee position 
	 */
	public EmployeePosition removeEmployeePosition(EmployeePosition employeePosition) {
		getEmployeePositions().remove(employeePosition);

		return employeePosition;
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
		Employee other = (Employee) obj;
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
		return "Employee [id=" + id + ", employeeNumber=" + employeeNumber + ", firstName=" + firstName + ", midName="
				+ midName + ", lastName=" + lastName + "]";
	}

}