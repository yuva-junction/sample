package com.yuvajunction.rentalapp.party.dao.model.converter;

public class DynamoDBTypeConverterException extends RuntimeException  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DynamoDBTypeConverterException(String errorMessage, Throwable err) {
	    super(errorMessage, err);
	}
}
