package com.microservice.order.service;


import com.microservice.order.entities.Order;
import com.microservice.order.exceptions.OrderDomainException;
import com.microservice.order.exceptions.OrderError;
import com.microservice.order.exceptions.ResourceNotFoundException;
import com.microservice.order.repository.IOrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class OrderService implements IOrderService{

    @Autowired
    private IOrderRepository orderRepository;

    /**
     * Servicio para buscar todos las ordenes
     *
     * @return Listado de ordenes
     */
    @Override
    @Transactional // Para que esté sincronizada con la bd
    public List<Order> findAll() {
        return (List<Order>) orderRepository.findAll();
    }
    /**
     * Busca una orden por su Id
     *
     * @param id identificador de la orden
     * @return objeto de tipo orden
     */
    @Override
    public Order findById(Long id) throws ResourceNotFoundException {
        Order order = orderRepository.findById(id).orElse(null);
        if (order == null) {
            throw new ResourceNotFoundException();

        }
        return order;
    }

    /**
     * Crea un nuevo producto
     *
     * @param  order a crear en la bd
     * @return Producto creado
     */
    @Override
    public Order create(Order order) throws OrderDomainException {
        List<OrderError> errors = validateDomain(order);

        if (!errors.isEmpty()) {
            throw new OrderDomainException(errors);
        }

        if (order.getDate() == null) {
            order.setDate(new Date());
        }

        return orderRepository.save(order);
    }

    /**
     * Modifica o edita una orden
     *
     * @param id,     identificador de la orden a modificar
     * @param order orden con los datos a editar
     * @return Orden modificada
     */
    @Override
    @Transactional
    public Order update(Order order, Long id) throws OrderDomainException, ResourceNotFoundException {
        Order order1 = this.findById(id);
        if (order1 == null) {
            throw new ResourceNotFoundException();
        }

        List<OrderError> errors = validateDomain(order);

        if (!errors.isEmpty()) {
            throw new OrderDomainException(errors);
        }

        order1.setDate(order.getDate());
        order1.setState(order.getState());

       // order1.setItems(order.getItems());
        //order1.setClient(order.getClient());

        return orderRepository.save(order1);
    }
    /**
     * Eliminar producto por su id
     *
     * @param id identificador del producto a eliminar
     */
    @Override
    @Transactional
    public void deleteById(Long id) throws ResourceNotFoundException {
        Order order = this.findById(id);
        if (order == null) {
            throw new ResourceNotFoundException();
        }
        orderRepository.deleteById(id);
    }
    /**
     * Aplica validaciones o reglas del dominio para una orden. Antes de ser
     * agregado o modificado.
     *
     * @param order orden a validad
     * @return lista de errores de validación
     */

    private List<OrderError> validateDomain(Order order) {
        List<OrderError> errors = new ArrayList<>();

        if (order.getId() == null) {
            errors.add(new OrderError(EnumErrorCodes.EMPTY_FIELD, "name", "El id de la orden es obligatorio"));
        }
        return errors;

    }
}
