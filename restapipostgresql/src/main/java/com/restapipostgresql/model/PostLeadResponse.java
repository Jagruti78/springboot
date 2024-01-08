package com.restapipostgresql.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



public class PostLeadResponse {
	

	private String status;
	
	private String data;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public PostLeadResponse(String status, String data) {
		super();
		this.status = status;
		this.data = data;
	}
	
	
	
	
}
