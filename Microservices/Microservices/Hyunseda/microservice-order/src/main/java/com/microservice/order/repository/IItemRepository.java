package com.microservice.order.repository;


import com.microservice.order.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IItemRepository extends JpaRepository<Item, Long> {
}
