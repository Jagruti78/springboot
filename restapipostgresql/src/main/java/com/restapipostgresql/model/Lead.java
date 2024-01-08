package com.restapipostgresql.model;

import java.text.SimpleDateFormat;
import java.util.Date;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Builder
@Table(name = "lead")

public class Lead {
	
	@Id
	@NotNull(message = "leadid is mandatory")
	private int leadid;
	
	@Column(name = "firstname")
	@NotEmpty(message = "firstname is mandatory")
	@Pattern(regexp = "^[A-Za-z]+$")
	private String firstname;

	@Column(name = "middlename")
	@Pattern(regexp = "^[A-Za-z]*$")
	private String middlename;
	
	@Column(name = "lastname")
	@NotEmpty(message = "lastname is mandatory")
	@Pattern(regexp = "^[A-Za-z]+$")
	private String lastname;

	@Column(name = "gender")
	@NotEmpty(message = "gender is mandatory")
	@Pattern(regexp = "^(Male|Female|Others)$")
	private String gender;
	
	@Column(name = "mobilenumber")
	@NotNull(message = "mobilenumber is mandatory")
	private long mobilenumber;

	@Column(name = "dob")
	@NotEmpty(message = "dob is mandatory")
	@JsonFormat(pattern = "dd/mm/yyyy")
	private String dob;
	
	@Column(name = "email")
	@NotEmpty(message = "email is mandatory")
	@Email
	private String email;
	
	public Lead() {
		
	}

	public Lead(int leadid, String firstname, String middlename, String lastname, String gender, long mobilenumber,
			String dob, String email) {
		super();
		this.leadid = leadid;
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
		this.gender = gender;
		this.mobilenumber = mobilenumber;
		this.dob = dob;
		this.email = email;
	}

	public int getLeadid() {
		return leadid;
	}

	public void setLeadid(int leadid) {
		this.leadid = leadid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(long mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		String pattern = "dd/MM/yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		String date = simpleDateFormat.format(new Date(dob));
		System.out.println(date);
		this.dob = date;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
}
