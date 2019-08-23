package com.yuvajunction.rentalapp.party.api.model;

import com.yuvajunction.rentalapp.party.dao.model.Party;

public class CreatePartyTo {
	
	private Party party;

	public Party getParty() {
		return party;
	}

	public void setParty(Party party) {
		this.party = party;
	}
}
