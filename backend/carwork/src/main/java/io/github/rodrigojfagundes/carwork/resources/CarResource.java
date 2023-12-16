package io.github.rodrigojfagundes.carwork.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.github.rodrigojfagundes.carwork.dto.CarDTO;
import io.github.rodrigojfagundes.carwork.services.CarService;

@RestController
@RequestMapping(value = "/cars")
public class CarResource {
	
	@Autowired
	private CarService service;
	
	@GetMapping
	public ResponseEntity<Page<CarDTO>> findAll(
			@RequestParam(value = "clientId", defaultValue = "0") Long clientId,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesperPage", defaultValue = "12") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "model") String orderBy)
	{
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		Page<CarDTO> cars = service.findAllPaged(clientId, pageRequest);
		
		return ResponseEntity.ok().body(cars);	
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CarDTO> findById (@PathVariable Long id) {
		CarDTO car = service.findById(id);
		return ResponseEntity.ok().body(car);
	}
	
	@PostMapping
	public ResponseEntity<CarDTO> insert (@Valid @RequestBody CarDTO dto) {
		CarDTO newDTO = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(newDTO.getId()).toUri();
		return ResponseEntity.created(uri).body(newDTO);
	}
	
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<CarDTO> update (@PathVariable Long id, @Valid @RequestBody CarDTO dto){
		CarDTO newDTO = service.update(id, dto);
		return ResponseEntity.ok().body(newDTO);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<CarDTO> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
