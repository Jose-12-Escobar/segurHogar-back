package com.daw.segurhogar.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daw.segurhogar.entities.Client;
import com.daw.segurhogar.repositories.ClientRepository;
import com.daw.segurhogar.repositories.PolicyRepository;
import com.daw.segurhogar.repositories.SinisterRepository;

@Service
public class ClientService implements IClientBO{
	
	@Autowired
	ClientRepository clientRepo;
	
	@Autowired
	PolicyRepository policyRepo;
	
	@Autowired
	SinisterRepository sinisterRepo;

	@Override
	public List<Client> ListaClientes() {
		return clientRepo.findAll();
	}

	/**
	 * Recupera un cliente por su Id
	 * 
	 * @param id no debe ser nulo
	 * @return Devuelve una instancia de cliente si existe, en caso contrario retorna null
	 */
	@Override
	public Client getCliente(Long id) {
		Optional<Client> client = clientRepo.findById(id);
		return client.orElse(null);
	}
	
	/**
	 *  * Recupera un cliente por su Documento
	*/
	
	@Override
	public Client findByDocumento(String documento) {
		Optional<Client> client = clientRepo.findByDocumento(documento);
		return client.orElse(null);
	}
	
	@Override
	public Client getClienteByName(String name) {
		Optional<Client> client = clientRepo.findByNombre(name);
		return client.orElse(null);
	}
	
	/**
	 * Recupera un cliente a partir del mail
	 * 
	 * @param mail del clinte a buscar
	 * @return Devuelve una instancia de cliente si se ha encontrado, en caso contrario retorna null
	 */
	@Override
	public Client getClientByMail(String mail) {
		return clientRepo.findByMail(mail);
	}

	/**
	 * Recupera un cliente a partir del teléfono
	 * 
	 * @param telefono del clinte a buscar
	 * @return Devuelve una instancia de cliente si se ha encontrado, en caso contrario retorna null
	 */
	@Override
	public Client getClientByTelefono(String telefono) {
		return clientRepo.findByTelefono(telefono);
	}

	/**
	 * Borra un cliente por su Id
	 * 
	 * @param id no debe ser nulo
	 * @return Devuelve una instancia de cliente que se ha borrado, en caso contrario retorna null
	 */
	@Override
	public Client delCliente(Long id) {

		Optional<Client> client = clientRepo.findById(id);
		if (client.isPresent()) clientRepo.deleteById(id);
		return client.orElse(null);
	}

	/**
	 * Actualiza los datos de un cliente 
	 * 
	 * @param client debe existir
	 * @return Devuelve una instancia de cliente que se ha actualizado, en caso contrario retorna null
	 */
	@Override
	public Client updCliente(Client client) {
		
		if (clientRepo.existsById(client.getIdCliente())) {
			clientRepo.save(client);	
		}
		
		return getCliente(client.getIdCliente());
	}

	/**
	 * Inserta un nuevo cliente 
	 * 
	 * @param client a crear
	 * @return Devuelve una instancia de cliente que se ha creado, en caso contrario retorna null
	 */
	@Override
	public Client insCliente(Client client) {
		clientRepo.save(client);
		return client;
	}


}
