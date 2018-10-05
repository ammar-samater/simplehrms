/**
 * 
 */
package com.simplehrms.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Ammar Samater
 *
 */
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class GeneralException extends java.lang.RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GeneralException(String message) {
		super(message);
	}

}
