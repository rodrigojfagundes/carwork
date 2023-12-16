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

import io.github.rodrigojfagundes.carwork.dto.ClientDTO;
import io.github.rodrigojfagundes.carwork.services.ClientService;


@RestController
@RequestMapping(value = "/clients")
public class ClientResource {
	
	
	@Autowired
	private ClientService service;
	
	
	@GetMapping
	public ResponseEntity<List<ClientDTO>> findAll() {
		List<ClientDTO> clients = service.findAll();
		return ResponseEntity.ok().body(clients);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ClientDTO> findById(@PathVariable Long id) {
		ClientDTO client = service.findById(id);
		return ResponseEntity.ok().body(client);
	}
	
	
	@PostMapping
	public ResponseEntity<ClientDTO> insert (@RequestBody ClientDTO dto) {
		ClientDTO newDTO = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(newDTO.getId()).toUri();
		return ResponseEntity.created(uri).body(newDTO);
	}
	
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ClientDTO> update (@PathVariable Long id, @RequestBody ClientDTO dto){
		ClientDTO newDTO = service.update(id, dto);
		return ResponseEntity.ok().body(newDTO);
	}
	
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ClientDTO> delete (@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
