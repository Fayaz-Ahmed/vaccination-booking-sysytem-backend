package com.example.demo.exceptions;


/**
 * Use this exception class to throw the data validation exceptions such as invalid role code, duplicate username etc
 */
public class ChartVDataValidationException extends ChartVException {

    private static final long serialVersionUID = 1L;

    public ChartVDataValidationException(String message, Object invalidValue) {
        super(message + " [" + invalidValue.toString() + "]");

    }

    public ChartVDataValidationException(String message) {
        super(message);
    }

}
