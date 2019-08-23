package com.yuvajunction.rentalapp.party.api;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yuvajunction.rentalapp.party.api.business.PartyService;
import com.yuvajunction.rentalapp.party.api.model.CreatePartyFrom;
import com.yuvajunction.rentalapp.party.api.model.CreatePartyTo;

@Controller
public class PartyRestController {

	
	@Autowired
	PartyService partyService;


	
	 @RequestMapping(value="/create", method = RequestMethod.POST)
	    public ResponseEntity<Object> createNewParty(
	    		@RequestBody  CreatePartyFrom requestBody
	    		){
			
			try {
				return  new ResponseEntity<Object>(partyService.createParty(requestBody.getEmailID()),HttpStatus.OK);
			} catch (Exception e) {
				return  new ResponseEntity<Object>("Error is creating new party",HttpStatus.EXPECTATION_FAILED);
			}
			
	    }
}
