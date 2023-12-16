package io.github.rodrigojfagundes.carwork.dto;

import java.io.Serializable;

import io.github.rodrigojfagundes.carwork.entities.Work;

public class WorkDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	private Long id;
	private String description;
	private Long carId;
	
	private UserDTO user;
	
	public WorkDTO() {
		
	}

	public WorkDTO(Long id, String description, UserDTO user, Long carId) {
		this.id = id;
		this.description = description;
		this.user = user;
		this.carId = carId;
	}
	
	
	
	public WorkDTO(Work entity) {
		id = entity.getId();
		description = entity.getDescription();
		user = new UserDTO(entity.getUser());
		carId = entity.getCar().getId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public UserDTO getUser() {
		return user;
	}
	
	public void setUser(UserDTO user) {
		this.user = user;
	}
	
	public Long getCarId() {
		return carId;
	}

	public void setCarId(Long carId) {
		this.carId = carId;
	}
	
}
