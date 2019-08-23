package com.yuvajunction.rentalapp.party.dao.model.converter;

import java.io.IOException;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yuvajunction.rentalapp.party.dao.model.PartyAddress;

public class AddressConverter implements DynamoDBTypeConverter<String, PartyAddress>{
	ObjectMapper mapper = new ObjectMapper();
	
	@Override
	public String convert(PartyAddress address){
		
		try {
			return mapper.writeValueAsString(address);
		} catch (JsonProcessingException e) {
			throw new DynamoDBTypeConverterException("Error in converting class type "+PartyAddress.class.getCanonicalName()+" to JSON string.", e);
		}
	}

	@Override
	public PartyAddress unconvert(String addressString) {
		
		try {
			return mapper.readValue(addressString, PartyAddress.class);
		} catch (Exception e) {
			throw new DynamoDBTypeConverterException("Error in converting JSON string to class type "+PartyAddress.class.getCanonicalName(), e);
		}
	}
	
	

}
