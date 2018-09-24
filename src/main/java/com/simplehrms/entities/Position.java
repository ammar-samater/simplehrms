package com.simplehrms.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the position database table.
 * 
 * @author Ammar Samater
 * @author
 */
@Entity
@Table(name = "position")
@NamedQuery(name = "Position.findAll", query = "SELECT p FROM Position p")
public class Position implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private int id;

	private String title;

	@Column(name = "title_Lang2")
	private String titleLang2;

	private String description;

	@Column(name = "description_Lang2")
	private String descriptionLang2;

	@Column(name = "min_salary")
	private BigDecimal minSalary;

	@Column(name = "max_salary")
	private BigDecimal maxSalary;

	@ElementCollection
	@CollectionTable(name = "qualifications", joinColumns = @JoinColumn(name = "position_id"))
	@Column(name = "required_qualifications")
	private List<String> requiredQualifications;

	@Column(name = "req_yrs_exp")
	private double requiredYearsOfExperience;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "positions_competencies", joinColumns = @JoinColumn(name = "position_id"), inverseJoinColumns = @JoinColumn(name = "Competence_id"))
	private List<Competence> competencies;

	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;

	public Position() {
	}

	/**
	 * @param id
	 * @param title
	 * @param titleLang2
	 * @param description
	 * @param descriptionLang2
	 * @param minSalary
	 * @param maxSalary
	 * @param requiredQualifications
	 * @param requiredYearsOfExperience
	 * @param competencies
	 * @param department
	 */
	public Position(int id, String title, String titleLang2, String description, String descriptionLang2,
			BigDecimal minSalary, BigDecimal maxSalary, List<String> requiredQualifications,
			double requiredYearsOfExperience, List<Competence> competencies, Department department) {
		this.id = id;
		this.title = title;
		this.titleLang2 = titleLang2;
		this.description = description;
		this.descriptionLang2 = descriptionLang2;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
		this.requiredQualifications = requiredQualifications;
		this.requiredYearsOfExperience = requiredYearsOfExperience;
		this.competencies = competencies;
		this.department = department;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the titleLang2
	 */
	public String getTitleLang2() {
		return titleLang2;
	}

	/**
	 * @param titleLang2
	 *            the titleLang2 to set
	 */
	public void setTitleLang2(String titleLang2) {
		this.titleLang2 = titleLang2;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the descriptionLang2
	 */
	public String getDescriptionLang2() {
		return descriptionLang2;
	}

	/**
	 * @param descriptionLang2
	 *            the descriptionLang2 to set
	 */
	public void setDescriptionLang2(String descriptionLang2) {
		this.descriptionLang2 = descriptionLang2;
	}

	/**
	 * @return the minSalary
	 */
	public BigDecimal getMinSalary() {
		return minSalary;
	}

	/**
	 * @param minSalary
	 *            the minSalary to set
	 */
	public void setMinSalary(BigDecimal minSalary) {
		this.minSalary = minSalary;
	}

	/**
	 * @return the maxSalary
	 */
	public BigDecimal getMaxSalary() {
		return maxSalary;
	}

	/**
	 * @param maxSalary
	 *            the maxSalary to set
	 */
	public void setMaxSalary(BigDecimal maxSalary) {
		this.maxSalary = maxSalary;
	}

	/**
	 * @return the requiredQualifications
	 */
	public List<String> getRequiredQualifications() {
		return requiredQualifications;
	}

	/**
	 * @param requiredQualifications
	 *            the requiredQualifications to set
	 */
	public void setRequiredQualifications(List<String> requiredQualifications) {
		this.requiredQualifications = requiredQualifications;
	}

	/**
	 * @return the requiredYearsOfExperience
	 */
	public double getRequiredYearsOfExperience() {
		return requiredYearsOfExperience;
	}

	/**
	 * @param requiredYearsOfExperience
	 *            the requiredYearsOfExperience to set
	 */
	public void setRequiredYearsOfExperience(double requiredYearsOfExperience) {
		this.requiredYearsOfExperience = requiredYearsOfExperience;
	}

	/**
	 * @return the competencies
	 */
	public List<Competence> getCompetencies() {
		return competencies;
	}

	/**
	 * @param competencies
	 *            the competencies to set
	 */
	public void setCompetencies(List<Competence> competencies) {
		this.competencies = competencies;
	}

	/**
	 * @return the department
	 */
	public Department getDepartment() {
		return department;
	}

	/**
	 * @param department
	 *            the department to set
	 */
	public void setDepartment(Department department) {
		this.department = department;
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
		result = prime * result + id;
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
		Position other = (Position) obj;
		if (id != other.id)
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
		return "Position [id=" + id + ", title=" + title + ", titleLang2=" + titleLang2 + ", description=" + description
				+ ", descriptionLang2=" + descriptionLang2 + ", minSalary=" + minSalary + ", maxSalary=" + maxSalary
				+ ", requiredQualifications=" + requiredQualifications + ", requiredYearsOfExperience="
				+ requiredYearsOfExperience + ", competencies=" + competencies + ", department=" + department + "]";
	}

}