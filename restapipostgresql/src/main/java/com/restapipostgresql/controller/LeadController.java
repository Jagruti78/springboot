package com.restapipostgresql.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapipostgresql.model.ApiError;
import com.restapipostgresql.model.ErrorResponse;
import com.restapipostgresql.model.GetLeadResponse;
import com.restapipostgresql.model.Lead;
import com.restapipostgresql.model.PostLeadResponse;
import com.restapipostgresql.service.ILeadService;

//@Validated
@RestController
@RequestMapping("/")
public class LeadController {
	
	@Autowired
	ILeadService leadService;
	
	@GetMapping("/api/v1/lead/get")
	public Object getAllLeads(@Param("mobileNumber") Long mobileNumber) {
		List<Lead> lead= leadService.getAllLeads(mobileNumber);
		if(lead.size()>0)
		return new GetLeadResponse("success", lead);
		else {
			String message="No Lead found with the Mobile Number ";
		List<String> msgList=new ArrayList<>();
		msgList.add(message);
		ErrorResponse errResponse=new ErrorResponse("E10011",msgList);
		ApiError apiError=new ApiError("error",errResponse);
		return ResponseEntity.ok(apiError);
		}
			
	}

	@PostMapping("/api/v1/lead/post")
	public Object createLead(@Valid @RequestBody Lead lead) {
		try {
		Lead getLead = leadService.getLeadbyId(lead);
		if (getLead!=null) {
		String message="Lead Already Exists in the database with the lead id";
		List<String> msgList=new ArrayList<>();
		msgList.add(message);
		ErrorResponse errResponse=new ErrorResponse("E10010",msgList);
		ApiError apiError=new ApiError("error",errResponse);
		return ResponseEntity.ok(apiError);
		}
		else {
			lead= leadService.createLead(lead);
			PostLeadResponse apiSuccess=new PostLeadResponse("success","Created Leads Successfully");
			return ResponseEntity.ok(apiSuccess);
		}
		}
		catch (NoSuchElementException e) {
	
		lead= leadService.createLead(lead);
		PostLeadResponse apiSuccess=new PostLeadResponse("success","Created Leads Successfully");
		return ResponseEntity.ok(apiSuccess);
		
		}
		
	}
}
