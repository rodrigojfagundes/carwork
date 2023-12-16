package io.github.rodrigojfagundes.carwork.dto;


@UserInserValid
public class UserInserDTO extends UserDTO {

	private static final long serialVersionUID = 1L;
	
	private String password;
	
	
	public UserInserDTO() {
		super();
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
}
