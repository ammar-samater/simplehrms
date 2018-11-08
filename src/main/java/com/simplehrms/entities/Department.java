package com.simplehrms.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonView;
import com.simplehrms.jsonview.View;

/**
 * The persistent class for the department database table.
 * 
 * @author Ammar Samater
 * @author
 */
@Entity
@Table(name = "Departments")
@NamedQuery(name = "Department.findAll", query = "SELECT d FROM Department d")
public class Department implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	@JsonView(View.Summary.class)
	private Long id;

	@Column(name = "department_id", unique = true)
	@JsonView(View.Summary.class)
	private String departmentId;

	@JsonView(View.Summary.class)
	private String name;

	@JsonView(View.Summary.class)
	private String nameLang2;

	@Column(name = "office_number")
	private String officeNumber;

	@Column(name = "floor_number")
	private Integer floorNumber;

	@Column(name = "building_name")
	private String buildingName;

	@ManyToOne
	@JoinColumn(name = "site_id")
	private Site site;

	public Department() {
	}

	/**
	 * @param id
	 */
	public Department(Long id) {
		this.id = id;
	}

	/**
	 * @param departmentId
	 */
	public Department(String departmentId) {
		this.departmentId = departmentId;
	}

	/**
	 * @param departmentId
	 * @param name
	 * @param nameLang2
	 * @param officeNumber
	 * @param floorNumber
	 * @param buildingName
	 * @param site
	 */
	public Department(String departmentId, String name, String nameLang2, String officeNumber, Integer floorNumber,
			String buildingName, Site site) {
		this.departmentId = departmentId;
		this.name = name;
		this.nameLang2 = nameLang2;
		this.officeNumber = officeNumber;
		this.floorNumber = floorNumber;
		this.buildingName = buildingName;
		this.site = site;
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
		return departmentId;
	}

	/**
	 * @param departmentId
	 *            the departmentId to set
	 */
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
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
		return buildingName;
	}

	/**
	 * @param buildingName
	 *            the buildingName to set
	 */
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	/**
	 * @return the site
	 */
	public Site getSite() {
		return site;
	}

	/**
	 * @param site
	 *            the site to set
	 */
	public void setSite(Site site) {
		this.site = site;
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
		return "Department [id=" + id + ", departmentId=" + departmentId + ", name=" + name + ", nameLang2=" + nameLang2
				+ ", officeNumber=" + officeNumber + ", floorNumber=" + floorNumber + ", buildingName=" + buildingName
				+ ", site=" + site + "]";
	}

}