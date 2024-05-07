package com.unicauca.domain.service;

import com.unicauca.domain.entity.Client;
import com.unicauca.domain.entity.Role;
import com.unicauca.presentation.rest.exceptions.ClientDomainException;
import com.unicauca.presentation.rest.exceptions.ResourceNotFoundException;

import java.util.List;

/**
 * Interfaz de operaciones de la bd de clientes
 *
 * @author
 *
 */

public interface IClientService {

    public List<Client> findAll();

    public Client findById(Long id) throws ResourceNotFoundException;

    public Client create(Client client) throws ClientDomainException;

    public Client update(Client client, Long id) throws ClientDomainException, ResourceNotFoundException;

    public void deleteById(Long id) throws ResourceNotFoundException;

    public List<Role> findAllRoles();
}