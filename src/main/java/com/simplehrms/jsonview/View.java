/**
 * 
 */
package com.simplehrms.jsonview;

/**
 * Jackson related features available in Spring Framework 4.x and Spring Boot that
 * allows the filtration fields depending on the context of serialization 
 * @author Ammar Samater
 *
 */
public class View {

	public interface Summary {
	}

	public interface Full extends Summary {
	}

}
