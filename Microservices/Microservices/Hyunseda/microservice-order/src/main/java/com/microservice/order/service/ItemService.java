package com.microservice.order.service;



import com.microservice.order.entities.Item;
import com.microservice.order.entities.Product;
import com.microservice.order.exceptions.ItemDomainException;
import com.microservice.order.exceptions.ItemError;
import com.microservice.order.exceptions.ResourceNotFoundException;
import com.microservice.order.repository.IItemRepository;
import com.microservice.order.responce.ProductByItemResponse;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService implements IItemService{

    @Autowired
    private IItemRepository itemRepository;
    @Autowired
    private IProductClientRest productClient;


    @Override
    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    @Override
    public Item findById(Long id) throws ResourceNotFoundException{

        Item item = itemRepository.findById(id).orElse(null);
        if(item == null){
            throw new ResourceNotFoundException();
        }
        return item;
    }

    @Transactional
    @Override
    public Item create(Item item) throws ItemDomainException {
        List<ItemError> errors = validateDomain(item);

        if (!errors.isEmpty()) {
            throw new ItemDomainException(errors);
        }
        return itemRepository.save(item);
    }

    @Transactional
    @Override
    public Item update(Item item, Long id) throws ItemDomainException, ResourceNotFoundException{
        Item item1 = this.findById(id);
        if (item1 == null) {
            throw new ResourceNotFoundException();
        }

        List<ItemError> errors = validateDomain(item);

        if (!errors.isEmpty()) {
            throw new ItemDomainException(errors);
        }

        item1.setAmount(item.getAmount());
        //item1.setOrder(item.getOrder());
        item1.setProduct(item.getProduct());

        return itemRepository.save(item1);
    }

    @Override
    public void deleteById(Long id) throws ResourceNotFoundException {
            Item item1 = this.findById(id);
            if (item1 == null) {
                throw new ResourceNotFoundException();
            }
            itemRepository.deleteById(id);
    }

    @Override
    public ProductByItemResponse ProductByItemResponse(Long idItem) {
        Item item = itemRepository.findById(idItem).orElse(new Item());

        // obtenes amunt del producto
        System.out.println("entrando ala implementacion esta a un paso de entrar"+item.getProduct().getId());
        System.out.println(item.getProduct().getId());
        Product product = productClient.detail(item.getProduct().getId());



        return ProductByItemResponse.builder()
                .product(product)

                .amount(item.getAmount())
                .build() ;


    }

    private List<ItemError> validateDomain(Item item) {
        List<ItemError> errors = new ArrayList<>();

        if (item.getId() == null) {
            errors.add(new ItemError(EnumErrorCodes.EMPTY_FIELD, "name", "El id del item es obligatorio"));
        }
        
        return errors;

    }
}
