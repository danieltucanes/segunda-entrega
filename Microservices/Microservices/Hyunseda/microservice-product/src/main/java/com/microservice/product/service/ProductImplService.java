package com.microservice.product.service;

import com.microservice.product.entities.Category;
import com.microservice.product.entities.Product;
import com.microservice.product.exceptions.ProductDomainException;
import com.microservice.product.exceptions.ProductError;
import com.microservice.product.exceptions.ResourceNotFoundException;
import com.microservice.product.persistence.CategoryRepository;
import com.microservice.product.persistence.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ProductImplService implements IProductService{


    //inyectando

    @Autowired
    private ProductRepository ProductRepository;

    @Autowired
    private ICategoryService categoryService;


    @Transactional
    @Override
    public List<Product> findAll() {
        return (List<Product>) ProductRepository.findAll();
    }

    @Override
    public Product findById(Long id) throws ResourceNotFoundException {
        Product prod = ProductRepository.findById(id).orElse(null);
        if (prod == null) {
            throw new ResourceNotFoundException();

        }
        return prod;
    }

    @Transactional
    @Override
    public Product create(Product product) throws ProductDomainException {
        List<ProductError> errors = validateDomain(product);

        if (!errors.isEmpty()) {
            throw new ProductDomainException(errors);
        }

        if (product.getCreateAt() == null) {
            product.setCreateAt(new Date());

        }

      //  product.setCategories(categories);



        return ProductRepository.save(product);
    }
    @Transactional
    @Override
    public Product update(Long id, Product product) throws ProductDomainException, ResourceNotFoundException {
        Product prod = this.findById(id);
        if (prod == null) {
            throw new ResourceNotFoundException();
        }

        List<ProductError> errors = validateDomain(product);

        if (!errors.isEmpty()) {
            throw new ProductDomainException(errors);
        }

        prod.setName(product.getName());
        prod.setPrice(product.getPrice());

        return ProductRepository.save(prod);
    }
    @Transactional
    @Override
    public void deleteById(Long id) throws ResourceNotFoundException {
        Product prod = this.findById(id);
        if (prod == null) {
            throw new ResourceNotFoundException();
        }
        ProductRepository.deleteById(id);
    }



    /**
     * Aplica validaciones o reglas del dominio para un producto. Antes de ser
     * agregado o modificado.
     *
     * @param product producto a validad
     * @return lista de errores de validación
     */

    private List<ProductError> validateDomain(Product product) {
        List<ProductError> errors = new ArrayList<>();

        if (product.getName() == null || product.getName().isBlank()) {
            errors.add(new ProductError(EnumErrorCodes.EMPTY_FIELD, "name", "El nombre del producto es obligatorio"));
        }

        if (product.getPrice() <= 0) {
            errors.add(new ProductError(EnumErrorCodes.INVALID_NUMBER, "price",
                    "El precio del producto es obligatorio y mayor a cero"));
        }
        return errors;

    }

}
