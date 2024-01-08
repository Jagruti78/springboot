package com.restapipostgresql.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapipostgresql.model.Lead;
import com.restapipostgresql.repository.LeadRepository;

@Service
public class LeadServiceImpl implements ILeadService{

	@Autowired
	LeadRepository leadRepository;
	
	@Override
	public Lead createLead(Lead lead) {
		// TODO Auto-generated method stub
		return leadRepository.save(lead);
	}

	@Override
	public List<Lead> getAllLeads(Long mobileNumber) {
		// TODO Auto-generated method stub
		return leadRepository.findByMobilenumber(mobileNumber);
	}

	@Override
	public Lead getLeadbyId(Lead lead) {
		// TODO Auto-generated method stub
		return leadRepository.findById(lead.getLeadid()).get();
	}

}
