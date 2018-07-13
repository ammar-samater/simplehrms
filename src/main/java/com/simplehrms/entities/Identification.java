package com.simplehrms.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the identification database table.
 * 
 * @author Ammar Samater
 * @author
 */
@Entity
@Table(name = "identification")
@NamedQuery(name = "Identification.findAll", query = "SELECT i FROM Identification i")
public class Identification implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	private Employee employee;

	@Column(name = "passport_number", nullable = false)
	private String passportNumber;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_of_issue", nullable = false)
	private Date dateOfIssue;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_of_expiration", nullable = false)
	private Date dateOfExpiration;

	@ManyToOne(optional = false)
	@JoinColumn(name = "place_of_issue", nullable = false)
	private City placeOfIssue;

	@ManyToOne(optional = false)
	@JoinColumn(name = "country_id", nullable = false)
	private Country nationality;

	private String profession;

	public Identification() {
	}

	/**
	 * @param employee
	 * @param passportNumber
	 * @param dateOfIssue
	 * @param dateOfExpiration
	 * @param placeOfIssue
	 * @param nationality
	 * @param profession
	 */
	public Identification(Employee employee, String passportNumber, Date dateOfIssue, Date dateOfExpiration,
			City placeOfIssue, Country nationality, String profession) {
		this.employee = employee;
		this.passportNumber = passportNumber;
		this.dateOfIssue = dateOfIssue;
		this.dateOfExpiration = dateOfExpiration;
		this.placeOfIssue = placeOfIssue;
		this.nationality = nationality;
		this.profession = profession;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
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
	 * @param employee the employee to set
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	/**
	 * @return the passportNumber
	 */
	public String getPassportNumber() {
		return passportNumber;
	}

	/**
	 * @param passportNumber the passportNumber to set
	 */
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	/**
	 * @return the dateOfIssue
	 */
	public Date getDateOfIssue() {
		return dateOfIssue;
	}

	/**
	 * @param dateOfIssue the dateOfIssue to set
	 */
	public void setDateOfIssue(Date dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}

	/**
	 * @return the dateOfExpiration
	 */
	public Date getDateOfExpiration() {
		return dateOfExpiration;
	}

	/**
	 * @param dateOfExpiration the dateOfExpiration to set
	 */
	public void setDateOfExpiration(Date dateOfExpiration) {
		this.dateOfExpiration = dateOfExpiration;
	}

	/**
	 * @return the placeOfIssue
	 */
	public City getPlaceOfIssue() {
		return placeOfIssue;
	}

	/**
	 * @param placeOfIssue the placeOfIssue to set
	 */
	public void setPlaceOfIssue(City placeOfIssue) {
		this.placeOfIssue = placeOfIssue;
	}

	/**
	 * @return the nationality
	 */
	public Country getNationality() {
		return nationality;
	}

	/**
	 * @param nationality the nationality to set
	 */
	public void setNationality(Country nationality) {
		this.nationality = nationality;
	}

	/**
	 * @return the profession
	 */
	public String getProfession() {
		return profession;
	}

	/**
	 * @param profession the profession to set
	 */
	public void setProfession(String profession) {
		this.profession = profession;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/* (non-Javadoc)
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
		Identification other = (Identification) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Identification [id=" + id + ", employee=" + employee + ", passportNumber=" + passportNumber
				+ ", dateOfIssue=" + dateOfIssue + ", dateOfExpiration=" + dateOfExpiration + ", placeOfIssue="
				+ placeOfIssue + ", nationality=" + nationality + ", profession=" + profession + "]";
	}

}