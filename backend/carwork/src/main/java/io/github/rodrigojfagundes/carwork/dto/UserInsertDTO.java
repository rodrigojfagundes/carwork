package io.github.rodrigojfagundes.carwork.dto;

import io.github.rodrigojfagundes.carwork.services.validations.UserInsertValid;

@UserInsertValid
public class UserInsertDTO extends UserDTO {

	private static final long serialVersionUID = 1L;
	
	private String password;
	
	
	public UserInsertDTO() {
		super();
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
}
