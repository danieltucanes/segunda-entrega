package com.microservice.order.service;


import com.microservice.order.entities.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "msvc-product", url = "localhost:8090/products")
public interface IProductClientRest {

 //   @GetMapping("/products/")
   // public List<Product> list();

    @GetMapping("/products/{id}")
    public Product detail(@PathVariable Long id);
/*
    @PostMapping("/products")
    public Product create(@RequestBody Product product);

    @PutMapping("/products/{id}")
    public Product update(@RequestBody Product producto, @PathVariable Long id);

    @DeleteMapping("/eliminar/{id}")
    public void delete(@PathVariable Long id);
 */
}

