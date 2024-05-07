package com.unicauca.presentation.rest;

import com.unicauca.domain.entity.Role;
import com.unicauca.domain.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @brief Servicios web de roles
 * @author Andres Felipe Castro (andresfcastro@unicauca.edu.co)
 */

@RestController
@RequestMapping("roles")
public class RoleController {

    @Autowired
    IRoleService roleService;

    /**
     * @brief Metodo de listar roles
     * @return Lista de todos los roles
     */
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Role> findAll() {
        return (List<Role>) roleService.findAll();
    }
}
