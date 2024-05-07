package com.microservice.product.controller;


import com.microservice.product.entities.Category;
import com.microservice.product.entities.Product;
import com.microservice.product.exceptions.ProductDomainException;
import com.microservice.product.exceptions.ResourceNotFoundException;
import com.microservice.product.persistence.CategoryRepository;
import com.microservice.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")

public class ProductController {
    @Autowired
    private IProductService productService;



    /**
     * Listar todos
     *
     * @return listado de productos en json
     */
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Product> findAll() {
        return (List<Product>) productService.findAll();
    }

    /**
     * Listar un producto por id
     *
     * @param id identificador
     * @return Producto en formato json
     * @throws Exception
     */
    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Product findById(@PathVariable Long id) throws ResourceNotFoundException {

        Product product = productService.findById(id);
        return product;
    }
    /**
     * Crear un producto
     *
     * @param product producto
     * @return producto creado
     */

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Product create(@RequestBody Product product) throws ProductDomainException {
        return productService.create(product);
    }


    /**
     * Editar
     *
     * @param product Producto a editar
     * @param id      identificador del producto
     * @return producto editado
     * @throws ResourceNotFoundException recurso no encontrado
     * @throws Exception                 Id no encontrado
     */
    @RequestMapping(value = "{id}", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public Product update(@RequestBody Product product, @PathVariable Long id)
            throws ProductDomainException, ResourceNotFoundException {
        return productService.update(id, product);
    }

    /**
     * Eliminar
     *
     * @param id id del producto
     * @throws ResourceNotFoundException id no encontrado
     */

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws ResourceNotFoundException {
        productService.deleteById(id);
    }
    @GetMapping("/products/{id}")
    public ResponseEntity<?> detail (@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok().body(productService.findById(id));
    }
}
