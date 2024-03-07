package com.daw.segurhogar.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.daw.segurhogar.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

	Optional<Client> findByNombre(String name);
	Optional<Client> findByDocumento(String dni);
	Client findByMail(String mail);
	Client findByTelefono(String telefono);

}
