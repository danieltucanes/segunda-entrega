package com.microservice.order.service;


import com.microservice.order.entities.Order;
import com.microservice.order.exceptions.OrderDomainException;
import com.microservice.order.exceptions.ResourceNotFoundException;

import java.util.List;

public interface IOrderService {
    public List<Order> findAll();

    public Order findById(Long id)throws ResourceNotFoundException;

    public Order create(Order order)throws OrderDomainException;

    public Order update(Order order, Long id) throws OrderDomainException, ResourceNotFoundException;

    public void deleteById(Long id)throws ResourceNotFoundException;

}
