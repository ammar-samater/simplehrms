package com.simplehrms.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonView;
import com.simplehrms.jsonview.View;

/**
 * The persistent class for the employee database table.
 * 
 * 
 * @author Ammar Samater
 */
@Entity
@Table(name = "Employees")
@NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	@JsonView(View.Summary.class)
	private Long id;

	@Column(name = "employee_Number", unique = true)
	@JsonView(View.Summary.class)
	private String employeeNumber;

	@Column(name = "first_name")
	@JsonView(View.Summary.class)
	private String firstName;

	@Column(name = "mid_name")

	private String midName;

	@Column(name = "last_name")
	@JsonView(View.Summary.class)
	private String lastName;

	@Column(name = "first_name_lang2")
	@JsonView(View.Summary.class)
	private String firstNameLang2;

	@Column(name = "mid_name_lang2")

	private String midNameLang2;

	@Column(name = "last_name_lang2")
	@JsonView(View.Summary.class)
	private String lastNameLang2;

	@Column(name = "preferred_name")
	
	private String preferredName;

	@Column(name = "preferred_name_lang2")
	private String preferredNameLang2;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "blood_type")
	private BloodType bloodType;

	@Temporal(TemporalType.DATE)
	@JsonView(View.Summary.class)
	private Date dob;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Temporal(TemporalType.DATE)
	@Column(name = "hire_date")
	@JsonView(View.Summary.class)
	private Date hireDate;

	@Enumerated(EnumType.STRING)
	@Column(name="martial_status") 
	private MartialStatus martialStatus;

	@Enumerated(EnumType.STRING)
	private Religion religion;
	
	@ElementCollection
	@CollectionTable(name="EMPLOYEE_EDUCATION")
	@JsonView(View.Full.class)
	private Collection<Education> educationLevel;
	
	@ManyToMany(cascade = { CascadeType.MERGE })
	@JoinTable(name = "positions_competencies", joinColumns = @JoinColumn(name = "position_id"), inverseJoinColumns = @JoinColumn(name = "Competence_id"))
	@JsonView(View.Full.class)
	private List<Competency> competencies;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	@JsonView(View.Summary.class)
	private Address address;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "home_con_address_id")
	@JsonView(View.Summary.class)
	private Address homeCountryAddress;

	public Employee() {
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
	public Gender getGender() {
		return gender;
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(Gender gender) {
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
	public MartialStatus getMartialStatus() {
		return martialStatus;
	}

	/**
	 * @param martialStatus
	 *            the martialStatus to set
	 */
	public void setMartialStatus(MartialStatus martialStatus) {
		this.martialStatus = martialStatus;
	}

	/**
	 * @return the religion
	 */
	public Religion getReligion() {
		return religion;
	}

	/**
	 * @param religion
	 *            the religion to set
	 */
	public void setReligion(Religion religion) {
		this.religion = religion;
	}

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
	
	

	/**
	 * @return the educationLevel
	 */
	public Collection<Education> getEducationLevel() {
		return educationLevel;
	}

	/**
	 * @param educationLevel the educationLevel to set
	 */
	public void setEducationLevel(Collection<Education> educationLevel) {
		this.educationLevel = educationLevel;
	}

	/**
	 * @return the competencies
	 */
	public List<Competency> getCompetencies() {
		return competencies;
	}

	/**
	 * @return the bloodType
	 */
	public BloodType getBloodType() {
		return bloodType;
	}

	/**
	 * @param bloodType the bloodType to set
	 */
	public void setBloodType(BloodType bloodType) {
		this.bloodType = bloodType;
	}

	/**
	 * @return the homeCountryAddress
	 */
	public Address getHomeCountryAddress() {
		return homeCountryAddress;
	}

	/**
	 * @param homeCountryAddress the homeCountryAddress to set
	 */
	public void setHomeCountryAddress(Address homeCountryAddress) {
		this.homeCountryAddress = homeCountryAddress;
	}

	/**
	 * @param competencies the competencies to set
	 */
	public void setCompetencies(List<Competency> competencies) {
		this.competencies = competencies;
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