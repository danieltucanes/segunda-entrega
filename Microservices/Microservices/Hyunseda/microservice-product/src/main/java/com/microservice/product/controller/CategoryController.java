package com.microservice.product.controller;

import com.microservice.product.entities.Category;
import com.microservice.product.exceptions.CategoryDomainException;
import com.microservice.product.exceptions.ResourceNotFoundException;
import com.microservice.product.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categories")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;
    /**
     * Listar todos
     *
     * @return listado de Categorias en json
     */
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Category> findAll() {
        return (List<Category>) categoryService.findAll();
    }

    /**
     * Listar un Categoria por id
     *
     * @param id identificador
     * @return Categoria en formato json
     * @throws Exception
     */
    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Category findById(@PathVariable Long id) throws ResourceNotFoundException {

        Category category = categoryService.findById(id);
        return category;
    }

    /**
     * Crear un producto
     *
     * @param category categoria
     * @return categoria creado
     */

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Category create(@RequestBody Category category) throws CategoryDomainException {
        return categoryService.create(category);
    }

    /**
     * Editar
     *
     * @param category categoria a editar
     * @param id       identificador de la categoria
     * @return categoria  editado
     * @throws ResourceNotFoundException recurso no encontrado
     * @throws Exception                 Id no encontrado
     */
    @RequestMapping(value = "{id}", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public Category update(@RequestBody Category category, @PathVariable Long id)
            throws CategoryDomainException, ResourceNotFoundException
    {
        return categoryService.update(id, category);
    }

    /**
     * Eliminar
     *
     * @param id id de LA CATEGORIA
     * @throws ResourceNotFoundException id no encontrado
     */

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws ResourceNotFoundException {
        categoryService.deleteById(id);
    }

}
