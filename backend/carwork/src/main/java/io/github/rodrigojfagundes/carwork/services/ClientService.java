package io.github.rodrigojfagundes.carwork.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.rodrigojfagundes.carwork.dto.ClientDTO;
import io.github.rodrigojfagundes.carwork.entities.Client;
import io.github.rodrigojfagundes.carwork.repositories.ClientRepository;
import io.github.rodrigojfagundes.carwork.services.exceptions.DatabaseException;
import io.github.rodrigojfagundes.carwork.services.exceptions.ResourceNotFoundException;

@Service
public class ClientService {
	
	
	
	private ClientRepository repository;
	
	
	@Transactional(readOnly = true)
	public List<ClientDTO> findAll(){
		List<Client> clients = repository.findAll();
		return clients.stream().map(client -> new ClientDTO(client)).collect(Collectors.toList());
	}
	
	
	@Transactional
	public ClientDTO findById(Long id) {
		Optional<Client> obj = repository.findById(id);
		Client client = obj.orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));
		return new ClientDTO(client);
	}
	
	@Transactional
	public ClientDTO insert(ClientDTO dto) {
		Client client = new Client();
		
		client.setName(dto.getName());
		client.setCpf(dto.getCpf());
		client.setCity(dto.getCity());
		
		return new ClientDTO(client);
	}
	
	
	@Transactional
	public ClientDTO update(Long id, ClientDTO dto) {
		try {
			Client client = repository.getOne(id);
			client.setName(dto.getName());
			client.setCpf(dto.getCpf());
			client.setCity(dto.getCity());
			
			return new ClientDTO(client);
		}
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id " + id + " not found");
		}
	}
	
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id " + id + " not found");
		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
	}
	
}
