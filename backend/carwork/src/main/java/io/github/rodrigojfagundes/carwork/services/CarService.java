package io.github.rodrigojfagundes.carwork.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.rodrigojfagundes.carwork.dto.CarDTO;
import io.github.rodrigojfagundes.carwork.dto.WorkDTO;
import io.github.rodrigojfagundes.carwork.entities.Car;
import io.github.rodrigojfagundes.carwork.entities.Client;
import io.github.rodrigojfagundes.carwork.entities.Work;
import io.github.rodrigojfagundes.carwork.repositories.CarRepository;
import io.github.rodrigojfagundes.carwork.repositories.ClientRepository;
import io.github.rodrigojfagundes.carwork.repositories.WorkRepository;
import io.github.rodrigojfagundes.carwork.services.exceptions.DatabaseException;
import io.github.rodrigojfagundes.carwork.services.exceptions.ResourceNotFoundException;

@Service
public class CarService {
	
	@Autowired
	private CarRepository repository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private WorkRepository workRepository;
	
	
	@Transactional(readOnly = true)
	public Page<CarDTO> findAllPaged (Long clientId, PageRequest pageRequest) {
		Client client = (clientId == 0) ? null : clientRepository.getOne(clientId);
		Page<Car> page = repository.find(client, pageRequest);
		return page.map(car -> new CarDTO(car));
	}
	
	
	@Transactional(readOnly = true)
	public CarDTO findById(Long id) {
		Optional<Car> obj = repository.findById(id);
		Car car = obj.orElseThrow(() -> new ResourceNotFoundException ("Carro não encontrado"));
		return new CarDTO(car);
	}
	
	@Transactional
	public CarDTO insert (CarDTO dto) {
		Car car = new Car();
		
		copyDtoToEntity(dto, car);
		
		car = repository.save(car);
		
		return new CarDTO(car);
	}
	
	
	@Transactional
	public CarDTO update (Long id, CarDTO dto) {
		try {
			Car car = repository.getOne(id);
			copyDtoToEntity(dto, car);
			car = repository.save(car);
			
			return new CarDTO(car);
		}
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id " + id + " not found");
		}
	}
	
	public void delete (Long id) {
		try {
			repository.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) {
			throw new DatabaseException("Integrity violation");
		}
	}
	
	
	private void copyDtoToEntity(CarDTO dto, Car entity) {
		entity.setModel(dto.getModel());
		entity.setPlate(dto.getPlate());
		
		Client client = clientRepository.getOne(dto.getClientId());
		entity.setClient(client);
		
		entity.getWorks().clear();
		
		for (WorkDTO workDTO : dto.getWorks()) {
			Work work = workRepository.getOne(workDTO.getCarId());
			entity.getWorks().add(work);
		}
	}
	
}