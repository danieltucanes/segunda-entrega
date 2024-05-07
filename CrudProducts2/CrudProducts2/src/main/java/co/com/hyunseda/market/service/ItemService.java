/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.hyunseda.market.service;

import co.com.hyunseda.market.access.IItemRepository;
import co.unicauca.microkernel.common.entities.Item;
import java.util.List;

/**
 *
 * @author X1605
 */
public class ItemService {
     IItemRepository repo;

    public ItemService(IItemRepository repo) {
        this.repo = repo;
    }

    public List<Item> findAll() {
        return repo.findAll();
    }
    
    public List<Item> itemsByOrder(Long idOrder) {
        return repo.itemsByOrder(idOrder);
    }
    
    public void create (Item item){
        repo.create(item);
    }
}
