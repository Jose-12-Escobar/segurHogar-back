package com.daw.segurhogar.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daw.segurhogar.entities.Client;
import com.daw.segurhogar.services.ClientService;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/client")
public class ClientController {
	
	@Autowired
	ClientService service;
	
	@GetMapping
	public ResponseEntity<List<Client>> list() {
		
		List<Client> clientes = service.ListaClientes();

		return ResponseEntity.ok(clientes);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Client> getClient(@PathVariable Long id){
		
		Client cliente = null;
		
		if (id != null) {
			cliente = service.getCliente(id);
		}
		
		return cliente != null ? ResponseEntity.ok(cliente) : ResponseEntity.notFound().build();
	}
	
	
	@GetMapping("/doc/{documento}")
	public ResponseEntity<Client> getClientByDocumento(@PathVariable String documento){
		
		Client cliente = null;
		
		if (documento != null) {
			cliente = service.findByDocumento(documento);
		}
		
		return cliente != null ? ResponseEntity.ok(cliente) : ResponseEntity.notFound().build();
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<Client> getClientByName(@PathVariable String name){
		
		Client cliente = null;
		
		if (name != null) {
			cliente = service.getClienteByName(name);
		}
		
		return cliente != null ? ResponseEntity.ok(cliente) : ResponseEntity.notFound().build();
	}


    @DeleteMapping("/{id}")
    public ResponseEntity<Client> deleteClient(@PathVariable Long id) {
    	
		Client cliente = null;
		
		if (id != null) {
			cliente = service.delCliente(id);
		}    	

    	return cliente != null ? ResponseEntity.ok(cliente) : ResponseEntity.notFound().build();
    }

    @PutMapping()
    public ResponseEntity<Client> updateClient(@RequestBody Client input) {
    	
    	Client cliente = service.updCliente(input);

		return cliente != null ? ResponseEntity.ok(cliente) : ResponseEntity.notFound().build();
    }

    @PostMapping()
    public ResponseEntity<Client> insertClient(@RequestBody Client input) {
    	
    	Client cliente = service.insCliente(input);

		return cliente != null ? ResponseEntity.ok(cliente) : ResponseEntity.notFound().build();
    }

    @GetMapping("/dni/{dni}")
	public ResponseEntity<Client> findByDocumento(@PathVariable String dni){
		
		Client cliente = null;
		
		if (dni != null) {
			cliente = service.findByDocumento(dni);
		}
		
		return cliente != null ? ResponseEntity.ok(cliente) : ResponseEntity.notFound().build();
	}
	
	@GetMapping("/mail/{mail}")
	public ResponseEntity<Client> getClientByMail(@PathVariable String mail){
		
		Client cliente = null;
		
		if (mail != null) {
			cliente = service.getClientByMail(mail);
		}
		
		return cliente != null ? ResponseEntity.ok(cliente) : ResponseEntity.notFound().build();
	}
	

	@GetMapping("/telefono/{telefono}")
	public ResponseEntity<Client> getClientByTelefono(@PathVariable String telefono){
		
		Client cliente = null;
		
		if (telefono != null) {
			cliente = service.getClientByTelefono(telefono);
		}
		
		return cliente != null ? ResponseEntity.ok(cliente) : ResponseEntity.notFound().build();
	}    

}
