/**
 * 
 */
package com.simplehrms.entities;

/**
 * @author Ammar Samater
 *
 */
public enum Education {

	PRIMARY("Primary"), INTERMEDIATE("Intermediate"), SECONDARY("Secondary"), DIPLOMA("Diploma"), ASSOCIATE(
			"Associate"), BACHELOR("Bachelor"), MASTERS("Masters"), PHD("PhD");

	private final String displayName;

	Education(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}
}
