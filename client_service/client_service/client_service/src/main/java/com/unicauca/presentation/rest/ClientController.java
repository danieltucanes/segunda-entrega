package com.unicauca.presentation.rest;


import com.unicauca.domain.entity.Client;
import com.unicauca.domain.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

import com.unicauca.presentation.rest.exceptions.ResourceNotFoundException;
import com.unicauca.presentation.rest.exceptions.ClientDomainException;

/**
 * Servicios web de clientes
 *
 * @author
 *
 */
@RestController
@RequestMapping("clients")
public class ClientController {

    @Autowired
    private IClientService clientService;

    /**
     * Listar todos
     *
     * @return listado de clientes en json
     */
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Client> findAll() {
        return (List<Client>) clientService.findAll();
    }

    /**
     * Listar un cliente por id
     *
     * @param id identificador
     * @return Cliente en formato json
     * @throws Exception    Id no encontrado
     */
    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Client finById(@PathVariable Long id) throws ResourceNotFoundException {
        return clientService.findById(id);
    }

    /**
     * Crear un cliente
     *
     * @param client cliente
     * @return cliente creado
     */
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Client create(@RequestBody Client client) throws ClientDomainException {
        return clientService.create(client);
    }

    /**
     * Editar
     *
     * @param client Cliente a editar
     * @param id      identificador del cliente
     * @return cliente editado
     * @throws ResourceNotFoundException recurso no encontrado
     * @throws Exception                 Id no encontrado
     */
    @RequestMapping(value = "{id}", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public Client update(@RequestBody Client client,@PathVariable Long id) throws ClientDomainException, ResourceNotFoundException {
             return clientService.update(client, id);
    }

    /**
     * Eliminar
     *
     * @param id id del cliente a eliminar
     * @throws ResourceNotFoundException id no encontrado
     */
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws ResourceNotFoundException{
        clientService.deleteById(id);
    }

}
