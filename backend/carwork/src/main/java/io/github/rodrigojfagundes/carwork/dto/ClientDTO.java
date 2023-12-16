package io.github.rodrigojfagundes.carwork.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import io.github.rodrigojfagundes.carwork.entities.Client;

public class ClientDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String cpf;
	private String city;
	
	private List<CarDTO> cars = new ArrayList<>();
	
	public ClientDTO() {
		
	}


	public ClientDTO(Long id, String name, String cpf, String city) {
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.city = city;
	}
	
	
	public ClientDTO(Client entity) {
		id = entity.getId();
		name = entity.getName();
		cpf = entity.getCpf();
		city = entity.getCity();
		entity.getCars().forEach(car -> this.cars.add(new CarDTO(car)));
	}
	
	
	

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}
	
	public List<CarDTO> getCars(){
		return cars;
	}
	
	
	
	
}
