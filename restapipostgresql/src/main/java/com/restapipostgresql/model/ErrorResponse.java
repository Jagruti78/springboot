package com.restapipostgresql.model;

import java.util.List;

public class ErrorResponse {

	  private String code;
	  private List<String> messages;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public List<String> getMessages() {
		return messages;
	}
	public void setMessages(List<String> messages) {
		this.messages = messages;
	}
	public ErrorResponse(String code, List<String> messages) {
		super();
		this.code = code;
		this.messages = messages;
	}
	  
	  
}
