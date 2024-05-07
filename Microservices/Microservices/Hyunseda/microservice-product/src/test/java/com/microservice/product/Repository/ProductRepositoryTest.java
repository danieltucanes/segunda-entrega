package com.microservice.product.Repository;

import com.microservice.product.entities.Category;
import com.microservice.product.entities.Product;
import com.microservice.product.exceptions.CategoryDomainException;
import com.microservice.product.exceptions.ProductDomainException;
import com.microservice.product.service.ICategoryService;
import com.microservice.product.service.IProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

@SpringBootTest
public class ProductRepositoryTest {
    @Autowired
   private IProductService IProductService;
    @Autowired
    private ICategoryService IcategoryService;

    @Test
    public void createLocalWithProducts() throws ProductDomainException, CategoryDomainException {
        Product product = new Product();
        product.setName("Product 2");
        product.setDescription("prueba");
        product.setCreateAt(new Date());
        product.setPrice(5000.0);
        product.setImages("insertando imagenes");
        product.setCharacteristics("nana");
        product.setSlug("lule");
        product.setStock(2);
        product.setKeywords("bebisito");

        Category category1 = IcategoryService.findByName("Category 1");
        if (category1 == null) {
            // Si no existe, crearla y guardarla en la base de datos
            category1 = new Category();
            category1.setName("Category 1");
            category1 = IcategoryService.create(category1);
        }

        Category category2 = IcategoryService.findByName("Category 2");
        if (category2 == null) {
            category2 = new Category();
            category2.setName("Category 2");
            category2 = IcategoryService.create(category2);
        }

        // Asignar las categorías al producto
      //  Product product = new Product();
        // Configurar los atributos del producto
        product.setCategories(Arrays.asList(category1, category2));

        // Crear el producto
        IProductService.create(product);


        //le mando la lista de categorias

       // product.setCategories(IcategoryService.findAll());
       // product.setCategories(categories);
      //  IProductService.create(product);



    }
}
