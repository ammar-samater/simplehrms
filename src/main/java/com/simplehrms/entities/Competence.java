/**
 * 
 */
package com.simplehrms.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author Ammar Samater
 *
 */
@Entity
@Table(name = "Comptencies")
@NamedQuery(name = "Competence.findAll", query = "SELECT c FROM Competence c")
public class Competence {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private int id;
	
	private String name;
	
	@Column(name = "name_lang2")
	private String nameLang2;
	
	private String description;
	
	@Column(name = "description_lang2")
	private String descriptionLang2;

	/**
	 * 
	 */
	public Competence() {
		super();
	}

	/**
	 * @param id
	 * @param name
	 * @param nameLang2
	 * @param description
	 * @param descriptionLang2
	 */
	public Competence(int id, String name, String nameLang2, String description, String descriptionLang2) {
		this.id = id;
		this.name = name;
		this.nameLang2 = nameLang2;
		this.description = description;
		this.descriptionLang2 = descriptionLang2;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
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
	 * @param nameLang2 the nameLang2 to set
	 */
	public void setNameLang2(String nameLang2) {
		this.nameLang2 = nameLang2;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
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
	 * @param descriptionLang2 the descriptionLang2 to set
	 */
	public void setDescriptionLang2(String descriptionLang2) {
		this.descriptionLang2 = descriptionLang2;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Competence other = (Competence) obj;
		if (id != other.id)
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Competence [id=" + id + ", name=" + name + ", nameLang2=" + nameLang2 + ", description=" + description
				+ ", descriptionLang2=" + descriptionLang2 + "]";
	}
	
	
	
	

}
