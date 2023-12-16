package io.github.rodrigojfagundes.carwork.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import io.github.rodrigojfagundes.carwork.entities.Car;

public class CarDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	private Long id;
	private String model;
	private String plate;
	private Long clientId;
	
	private List<WorkDTO> works = new ArrayList<>();
	
	
	public CarDTO() {
		
	}


	public CarDTO(Long id, String model, String plate, Long clientId) {
		this.id = id;
		this.model = model;
		this.plate = plate;
		this.clientId = clientId;
	}
	

	public CarDTO(Car entity) {
		id = entity.getId();
		model = entity.getModel();
		plate = entity.getPlate();
		clientId = entity.getClient().getId();
		entity.getWorks().forEach(work -> this.works.add(new WorkDTO(work)));
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public String getPlate() {
		return plate;
	}


	public void setPlate(String plate) {
		this.plate = plate;
	}


	public Long getClientId() {
		return clientId;
	}


	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}


	public List<WorkDTO> getWorks() {
		return works;
	}

	
	
	
}
