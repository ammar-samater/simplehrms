package com.simplehrms.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the address database table.
 * 
 * @author Ammar Samater
 * @author
 */
@Entity
@Table(name = "address")
@NamedQuery(name = "Address.findAll", query = "SELECT a FROM Address a")
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private Long id;

	@Column(name = "unit_number")
	private String unitNumber;

	@Column(name = "street_number")
	private String streetNumber;

	@Column(name = "street_name", nullable = false)
	private String streetName;

	@ManyToOne(optional = false)
	@JoinColumn(name = "city_id", nullable = false)
	private City city;

	@Column(name = "postal_code")
	private String postalCode;

	@Column(name = "additional_number")
	private String additionalNumber;

	/**
	 * 
	 */
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param unitNumber
	 * @param streetNumber
	 * @param streetName
	 * @param city
	 * @param postalCode
	 * @param additionalNumber
	 */
	public Address(String unitNumber, String streetNumber, String streetName, City city, String postalCode,
			String additionalNumber) {
		this.unitNumber = unitNumber;
		this.streetNumber = streetNumber;
		this.streetName = streetName;
		this.city = city;
		this.postalCode = postalCode;
		this.additionalNumber = additionalNumber;
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
	 * @return the unitNumber
	 */
	public String getUnitNumber() {
		return unitNumber;
	}

	/**
	 * @param unitNumber
	 *            the unitNumber to set
	 */
	public void setUnitNumber(String unitNumber) {
		this.unitNumber = unitNumber;
	}

	/**
	 * @return the streetNumber
	 */
	public String getStreetNumber() {
		return streetNumber;
	}

	/**
	 * @param streetNumber
	 *            the streetNumber to set
	 */
	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	/**
	 * @return the streetName
	 */
	public String getStreetName() {
		return streetName;
	}

	/**
	 * @param streetName
	 *            the streetName to set
	 */
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	/**
	 * @return the city
	 */
	public City getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(City city) {
		this.city = city;
	}

	/**
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * @param postalCode
	 *            the postalCode to set
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * @return the additionalNumber
	 */
	public String getAdditionalNumber() {
		return additionalNumber;
	}

	/**
	 * @param additionalNumber
	 *            the additionalNumber to set
	 */
	public void setAdditionalNumber(String additionalNumber) {
		this.additionalNumber = additionalNumber;
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
		Address other = (Address) obj;
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
		return "Address [id=" + id + ", unitNumber=" + unitNumber + ", streetNumber=" + streetNumber + ", streetName="
				+ streetName + ", city=" + city + ", postalCode=" + postalCode + ", additionalNumber="
				+ additionalNumber + "]";
	}

}