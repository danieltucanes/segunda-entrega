package com.microservice.order.service;



import com.microservice.order.entities.Item;
import com.microservice.order.exceptions.ItemDomainException;
import com.microservice.order.exceptions.ResourceNotFoundException;
import com.microservice.order.responce.ProductByItemResponse;

import java.util.List;

public interface IItemService {
    public List<Item> findAll();

    public Item findById(Long id)throws ResourceNotFoundException;

    public Item create(Item item)throws ItemDomainException;

    public Item update(Item item, Long id) throws ItemDomainException, ResourceNotFoundException;

    public void deleteById(Long id)throws ResourceNotFoundException;

    ProductByItemResponse ProductByItemResponse (Long idItem);


}
