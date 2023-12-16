package io.github.rodrigojfagundes.carwork.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.github.rodrigojfagundes.carwork.dto.WorkDTO;
import io.github.rodrigojfagundes.carwork.services.WorkService;

@RestController
@RequestMapping(value = "/works")
public class WorkResource {
	
	@Autowired
	private WorkService service;
	
	
	@GetMapping
	public ResponseEntity<List<WorkDTO>> findAll() {
		List<WorkDTO> works = service.findAll();
		return ResponseEntity.ok().body(works);
	}
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<WorkDTO> findById(@PathVariable Long id) {
		WorkDTO work = service.findById(id);
		return ResponseEntity.ok().body(work);
	}
	
	
	@PostMapping
	public ResponseEntity<WorkDTO> insert(@RequestBody WorkDTO dto) {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	
	@PutMapping
	public ResponseEntity<WorkDTO> update (@PathVariable Long id, @RequestBody WorkDTO dto) {
		WorkDTO newDTO = service.update(id, dto);
		return ResponseEntity.ok().body(newDTO);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<WorkDTO> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
	
}