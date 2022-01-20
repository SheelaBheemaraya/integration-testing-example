package com.thbs.bt.integrationtestingcrud.controller.request;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class CreateEmployeeRequest {
	@NotNull
	private String name;
	@NotNull
	private String email;

	@NotNull
	private LocalDate joiningDate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}
	
	

}
