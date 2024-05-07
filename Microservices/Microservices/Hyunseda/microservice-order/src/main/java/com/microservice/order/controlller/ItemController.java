package com.microservice.order.controlller;


import com.microservice.order.entities.Item;
import com.microservice.order.exceptions.ItemDomainException;
import com.microservice.order.exceptions.ResourceNotFoundException;
import com.microservice.order.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Servicios web de items
 *
 * @author
 */
@RestController
@RequestMapping("items")
public class ItemController {

    @Autowired
    private IItemService itemService;

    /**
     * Listar todos
     *
     * @return listado de items en json
     */

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Item> findAll() {
        return (List<Item>) itemService.findAll();
    }

    /**
     * Listar un Item por id
     *
     * @param id identificador
     * @return Item en formato json
     * @throws Exception
     */
    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Item findById(@PathVariable Long id) throws ResourceNotFoundException {

        Item item = itemService.findById(id);
        return item;
    }

    /**
     * Crear un item
     *
     * @param item item
     * @return item creado
     */

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Item create(@RequestBody Item item) throws ItemDomainException {

        return itemService.create(item);
    }

    /**
     * Editar
     *
     * @param item Item a editar
     * @param id   identificador del item
     * @return item editado
     * @throws ResourceNotFoundException recurso no encontrado
     * @throws Exception                 Id no encontrado
     */
    @RequestMapping(value = "{id}", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public Item update(@RequestBody Item item, @PathVariable Long id)
            throws ItemDomainException, ResourceNotFoundException {
        return itemService.update(item, id);
    }

    /**
     * Eliminar
     *
     * @param id id del item
     * @throws ResourceNotFoundException id no encontrado
     */

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws ResourceNotFoundException {
        itemService.deleteById(id);
    }

    @GetMapping("/search-products/{id}")
    public ResponseEntity<?> detail(@PathVariable Long id) throws ResourceNotFoundException {
        System.out.println("si entro"+id);
        return ResponseEntity.ok().body(itemService.ProductByItemResponse(id));




    }
}
