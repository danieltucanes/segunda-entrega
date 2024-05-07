package com.unicauca.domain.service;

import com.unicauca.access.IClientDao;
import com.unicauca.domain.entity.Client;
import com.unicauca.domain.entity.Role;
import com.unicauca.presentation.rest.exceptions.ClientDomainException;
import com.unicauca.presentation.rest.exceptions.ResourceNotFoundException;
import com.unicauca.presentation.rest.exceptions.ClientError;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementación de la Interfaz IClientService
 *
 * @author
 *
 */
@Service
public class ClientServiceImp implements IClientService{

    /**
     * Inyección de cliente Dao
     */
    @Autowired
    private IClientDao clientDao;

    private IRoleClientRest roleClientRest;
    /**
     * Servicio para buscar todos los clientes
     *
     * @return Listado de clientes
     */
    @Override
    @Transactional(readOnly = true) // Para que esté sincronizada con la bd
    public List<Client> findAll() {
        return (List<Client>) clientDao.findAll();
    }

    /**
     * Busca un cliente por su Id
     *
     * @param id identificador del cliente
     * @return objeto de tipo cliente
     */
    @Override
    public Client findById(Long id) throws ResourceNotFoundException {
        Client client = clientDao.findById(id).orElse(null);
        if (client == null) {
            throw new ResourceNotFoundException();

        }
        return client;
    }

    /**
     * Crea un nuevo cliente
     *
     * @param client cliente a crear en la bd
     * @return Client cliente creado
     */

    @Override
    @Transactional
    public Client create(Client client) throws ClientDomainException {

        List<ClientError> errors = validateDomain(client);

        if (!errors.isEmpty()) {
            throw new ClientDomainException(errors);
        }
        return clientDao.save(client);
    }

    /**
     * Aplica validaciones o reglas del dominio para un cliente. Antes de ser
     * agregado o modificado.
     *
     * @param client cliente a validar
     * @return lista de errores de validación
     */

    private List<ClientError> validateDomain(Client client) {
        List<ClientError> errors = new ArrayList<>();

        if (client.getFirstName() == null || client.getFirstName().isBlank()) {
            errors.add(new ClientError(EnumErrorCodes.EMPTY_FIELD, "First name", "El nombre del cliente es obligatorio"));
        }

        if (client.getLastName() == null || client.getLastName().isBlank()) {
            errors.add(new ClientError(EnumErrorCodes.EMPTY_FIELD, "Last name", "El apellido del cliente es obligatorio"));
        }

        if (client.getAddress() == null || client.getAddress().isBlank()) {
            errors.add(new ClientError(EnumErrorCodes.EMPTY_FIELD, "Adress", "La dirección del cliente es obligatoria"));
        }
        return errors;

    }

    @Override
    @Transactional
    public Client update(Client client, Long id) throws ClientDomainException, ResourceNotFoundException {
        Client cliente = this.findById(id);
        if (cliente == null) {
            throw new ResourceNotFoundException();
        }

        List<ClientError> errors = validateDomain(client);

        if (!errors.isEmpty()) {
            throw new ClientDomainException(errors);
        }

        cliente.setFirstName(client.getFirstName());
        cliente.setLastName(client.getLastName());
        cliente.setAddress(client.getAddress());

        return clientDao.save(cliente);
    }

    /**
     * Eliminar cliente por su id
     *
     * @param id identificador del cliente a eliminar
     */
    @Override
    @Transactional
    public void deleteById(Long id) throws ResourceNotFoundException{
         Client client = this.findById(id);
         if (client == null) {
             throw new ResourceNotFoundException();
         }
        clientDao.deleteById(id);
    }

    @Override
    @Transactional
    public List<Role> findAllRoles(){
        return roleClientRest.findAll();
    }
}
