package com.simplehrms.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The persistent class for the country database table.
 * 
 * @author Ammar Samater
 * @author
 */
@Entity
@Table(name = "Countries")
@NamedQuery(name = "Country.findAll", query = "SELECT c FROM Country c")
public class Country implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "code")
	private String code;

	@JsonProperty("Name")
	private String name;

	@Column(name = "name_lang2")
	@JsonProperty("الإسم")
	private String nameLang2;

	public Country() {
	}

	/**
	 * @param code
	 * @param name
	 * @param nameLang2
	 */
	public Country(String code, String name, String nameLang2) {
		this.code = code;
		this.name = name;
		this.nameLang2 = nameLang2;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
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
		result = prime * result + ((code == null) ? 0 : code.hashCode());
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
		Country other = (Country) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
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
		return "Country [countryCode=" + code + ", name=" + name + ", nameLang2=" + nameLang2 + "]";
	}

}