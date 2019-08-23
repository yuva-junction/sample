package com.yuvajunction.rentalapp.party.api.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuvajunction.rentalapp.party.api.model.CreatePartyTo;
import com.yuvajunction.rentalapp.party.dao.PartyDAO;
import com.yuvajunction.rentalapp.party.dao.model.Party;

@Service
public class PartyService {
	
	@Autowired
	PartyDAO partyDAO;
	
	
	public CreatePartyTo createParty(String emailID) throws Exception {
		Party party = new Party();
		party.setEmailID(emailID);
		partyDAO.addNewItem(party);
		
		CreatePartyTo partyTo = new CreatePartyTo();
		partyTo.setParty(party);
		
		return partyTo;
	}
}
