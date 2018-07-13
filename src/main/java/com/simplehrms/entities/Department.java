package com.simplehrms.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the department database table.
 * 
 * @author Ammar Samater
 * @author
 */
@Entity
@Table(name = "department")
@NamedQuery(name = "Department.findAll", query = "SELECT d FROM Department d")
public class Department implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private Long id;

	@Column(name = "department_id", unique = true)
	private String DepartmentId;

	private String name;

	private String nameLang2;

	@ManyToOne
	@JoinColumn(name = "location_id")
	private Location location;

	public Department() {
	}

	/**
	 * @param name
	 * @param nameLang2
	 * @param location
	 */
	public Department(String DepartmentId, String name, String nameLang2, Location location) {
		this.DepartmentId = DepartmentId;
		this.name = name;
		this.nameLang2 = nameLang2;
		this.location = location;
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
	 * @return the departmentId
	 */
	public String getDepartmentId() {
		return DepartmentId;
	}

	/**
	 * @param departmentId
	 *            the departmentId to set
	 */
	public void setDepartmentId(String departmentId) {
		DepartmentId = departmentId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the nameLang2
	 */
	public String getNameLang2() {
		return nameLang2;
	}

	/**
	 * @param nameLang2
	 *            the nameLang2 to set
	 */
	public void setNameLang2(String nameLang2) {
		this.nameLang2 = nameLang2;
	}

	/**
	 * @return the location
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * @param location
	 *            the location to set
	 */
	public void setLocation(Location location) {
		this.location = location;
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
		Department other = (Department) obj;
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
		return "Department [id=" + id + ", DepartmentId=" + DepartmentId + ", name=" + name + ", nameLang2=" + nameLang2
				+ ", location=" + location + "]";
	}

}