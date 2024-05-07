package com.microservice.order.repository;


import com.microservice.order.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<Order, Long> {
}
