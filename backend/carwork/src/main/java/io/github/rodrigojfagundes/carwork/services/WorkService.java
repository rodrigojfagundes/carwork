package io.github.rodrigojfagundes.carwork.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.rodrigojfagundes.carwork.dto.WorkDTO;
import io.github.rodrigojfagundes.carwork.entities.Car;
import io.github.rodrigojfagundes.carwork.entities.Work;
import io.github.rodrigojfagundes.carwork.repositories.CarRepository;
import io.github.rodrigojfagundes.carwork.repositories.WorkRepository;
import io.github.rodrigojfagundes.carwork.services.exceptions.DatabaseException;
import io.github.rodrigojfagundes.carwork.services.exceptions.ResourceNotFoundException;

@Service
public class WorkService {
	
	@Autowired
	private WorkRepository repository;
	
	@Autowired
	private CarRepository carRepository;
	
	
	@Transactional(readOnly = true)
	public List<WorkDTO> findAll() {
		List<Work> works = repository.findAll();
		return works.stream().map(work -> new WorkDTO(work)).collect(Collectors.toList());
	}
	
	@Transactional
	public WorkDTO findById(Long id) {
		Optional<Work> obj = repository.findById(id);
		Work work = obj.orElseThrow(() -> new ResourceNotFoundException("Work not found"));
		
		return new WorkDTO(work);
	}
	
	
	@Transactional
	public WorkDTO insert(WorkDTO dto) {
		Work work = new Work();
		
		Car car = carRepository.getOne(dto.getCarId());
		
		work.setCar(car);
		work.setDescription(dto.getDescription());
		
		work = repository.save(work);
		
		return new WorkDTO(work);
	}
	
	@Transactional
	public WorkDTO update (Long id, WorkDTO dto) {
		try {
			Work work = new Work();
			
			Car car = carRepository.getOne(dto.getCarId());
			
			work.setCar(car);
			work.setDescription(dto.getDescription());
			
			return new WorkDTO(work);
			
		}
		catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id " + id + " not found");
		}
	}
	
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id " + " not found");
		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
	}
	
	
}
