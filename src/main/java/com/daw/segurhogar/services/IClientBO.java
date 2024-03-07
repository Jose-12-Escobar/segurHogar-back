package com.daw.segurhogar.services;

import java.util.List;

import com.daw.segurhogar.entities.Client;

public interface IClientBO {
	
	List<Client> ListaClientes();
	Client getCliente(Long id);
	Client delCliente(Long id);
	Client updCliente(Client client);
	Client insCliente(Client client);
	Client getClientByMail(String mail);
	Client getClientByTelefono(String telefono);
	Client findByDocumento(String documento);
	Client getClienteByName(String name);

}
