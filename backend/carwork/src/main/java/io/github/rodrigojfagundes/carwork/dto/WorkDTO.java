package io.github.rodrigojfagundes.carwork.dto;

import java.io.Serializable;

import io.github.rodrigojfagundes.carwork.entities.Work;

public class WorkDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	private Long id;
	private String description;
	private Long carId;
	private String carModel;
	private String clientName;
	private String carPlate;
	
	public WorkDTO() {
		
	}

	public WorkDTO(Long id, String description) {
		this.id = id;
		this.description = description;
	}
	
	
	
	public WorkDTO(Work entity) {
		id = entity.getId();
		description = entity.getDescription();
		carId = entity.getCar().getId();
		carModel = entity.getCar().getModel();
		clientName = entity.getCar().getClient().getName();
		carPlate = entity.getCar().getPlate();
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

	public Long getCarId() {
		return carId;
	}

	public void setCarId(Long carId) {
		this.carId = carId;
	}
	
	public String getCarModel() {
		return carModel;
	}
	
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getCarPlate() {
		return carPlate;
	}

	public void setCarPlate(String carPlate) {
		this.carPlate = carPlate;
	}
	
	
	
}
