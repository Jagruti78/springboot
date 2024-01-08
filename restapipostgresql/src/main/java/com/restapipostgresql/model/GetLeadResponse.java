package com.restapipostgresql.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



public class GetLeadResponse {
	

	private String status;
	
	private List<Lead> data;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Lead> getData() {
		return data;
	}

	public void setData(List<Lead> data) {
		this.data = data;
	}

	public GetLeadResponse(String status, List<Lead> data) {
		super();
		this.status = status;
		this.data = data;
	}
	
	
	
	
}
