/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.hyunseda.market.service;

import co.com.hyunseda.market.access.IOrderRepository;
import co.unicauca.microkernel.common.entities.Item;
import co.unicauca.microkernel.common.entities.Order;
import java.util.List;



/**
 *
 * @author X1605
 */
public class OrderService {
   IOrderRepository repo;

    public OrderService(IOrderRepository repo) {
        this.repo = repo;
    }

    public List<Order> findAll() {
        return repo.findAll();
    }
    
    public void create(Order order){
        repo.create(order);
    }
    
    public void publish (Long id){
        repo.publish(id);
    }
}
