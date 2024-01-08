package com.restapipostgresql.service;

import java.util.List;

import com.restapipostgresql.model.Lead;

public interface ILeadService {

	Lead createLead(Lead lead);
	
	List<Lead> getAllLeads (Long mobileNumber);
	
	Lead getLeadbyId(Lead lead);
	
}
