/**
 * 
 */
package com.simplehrms.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the location database table.
 * 
 * @author Ammar Samater
 * @author
 */
@Entity
@Table(name = "location")
@NamedQuery(name = "Location.findAll", query = "SELECT l FROM Location l")
public class Location implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private Long id;

	@Column(name = "office_number")
	private String officeNumber;

	@Column(name = "floor_number")
	private Integer floorNumber;

	@Column(name = "buildingName")
	private String BuildingName;

	@ManyToOne
	@JoinColumn(name = "address_id")
	private Address address;

	/**
	 * 
	 */
	public Location() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param officeNumber
	 * @param floorNumber
	 * @param buildingName
	 * @param address
	 */
	public Location(String officeNumber, Integer floorNumber, String buildingName, Address address) {
		this.officeNumber = officeNumber;
		this.floorNumber = floorNumber;
		BuildingName = buildingName;
		this.address = address;
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
	 * @return the officeNumber
	 */
	public String getOfficeNumber() {
		return officeNumber;
	}

	/**
	 * @param officeNumber
	 *            the officeNumber to set
	 */
	public void setOfficeNumber(String officeNumber) {
		this.officeNumber = officeNumber;
	}

	/**
	 * @return the floorNumber
	 */
	public Integer getFloorNumber() {
		return floorNumber;
	}

	/**
	 * @param floorNumber
	 *            the floorNumber to set
	 */
	public void setFloorNumber(Integer floorNumber) {
		this.floorNumber = floorNumber;
	}

	/**
	 * @return the buildingName
	 */
	public String getBuildingName() {
		return BuildingName;
	}

	/**
	 * @param buildingName
	 *            the buildingName to set
	 */
	public void setBuildingName(String buildingName) {
		BuildingName = buildingName;
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
		Location other = (Location) obj;
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
		return "Location [id=" + id + ", officeNumber=" + officeNumber + ", floorNumber=" + floorNumber
				+ ", BuildingName=" + BuildingName + ", address=" + address + "]";
	}

}
