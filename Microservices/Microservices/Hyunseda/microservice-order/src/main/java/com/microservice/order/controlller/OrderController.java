package com.microservice.order.controlller;


import com.microservice.order.entities.Order;
import com.microservice.order.exceptions.OrderDomainException;
import com.microservice.order.exceptions.ResourceNotFoundException;
import com.microservice.order.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("orders")
public class OrderController {
    @Autowired
    private IOrderService orderService;

    /**
     * Listar todos
     *
     * @return listado de ordenens en json
     */
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Order> findAll() {
        return (List<Order>) orderService.findAll();
    }

    /**
     * Listar una orden por id
     *
     * @param id identificador
     * @return Order en formato json
     * @throws Exception
     */
    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Order findById(@PathVariable Long id) throws ResourceNotFoundException {

        Order order = orderService.findById(id);
        return order;
    }

    /**
     * Crear una Orden
     *
     * @param order orden
     * @return orden creada
     */

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Order create(@RequestBody Order order) throws OrderDomainException {
        return orderService.create(order);
    }

    /**
     * Editar
     *
     * @param order Orden a editar
     * @param id      identificador de la orden
     * @return orden editada
     * @throws ResourceNotFoundException recurso no encontrado
     * @throws Exception                 Id no encontrado
     */
    @RequestMapping(value = "{id}", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public Order update(@RequestBody Order order, @PathVariable Long id)
            throws OrderDomainException, ResourceNotFoundException {
        return orderService.update(order, id);
    }

    /**
     * Eliminar
     *
     * @param id id de la orden
     * @throws ResourceNotFoundException id no encontrado
     */

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws ResourceNotFoundException {
        orderService.deleteById(id);
    }
}
