package com.example.demo.exceptions;


/**
 * Use this exception class to wrap and throw the database level persistence exceptions such as {@link java.sql.SQLIntegrityConstraintViolationException}
 * 
 *
 *
 */
public class ChartVPersistenceException extends ChartVException {

	private static final long serialVersionUID = 1L;

	public ChartVPersistenceException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}


	public ChartVPersistenceException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	

}
