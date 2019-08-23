package com.yuvajunction.rentalapp.party.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.yuvajunction.rentalapp.party.dao.model.Party;

@Component
public class PartyDAO {
	
	AmazonDynamoDB  dbClient = AmazonDynamoDBClientBuilder.standard()
								.withCredentials(new ProfileCredentialsProvider(
															"./resources/aws-credentials", 
															"dynamodb"
															)
												)
								.build();
	
	DynamoDBMapper dbMapper = new DynamoDBMapper(dbClient);
	
	/*
	 * Add a new item in Party table. Check if either the email or phone number exists. If yes, then throws error.
	 */
	public void addNewItem(Party party) throws Exception{
		
		//fetch item by email ID or cell phone.call the below if no item fetched. If item exists throw error.
		
		dbMapper.save(party);
		
		
	}
	
}
