package com.unicauca.presentation.rest;

import java.util.List;

import com.unicauca.domain.entity.User;
import com.unicauca.domain.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

/**
 * @brief Servicios web de usuarios
 * @author Andres Felipe Castro (andresfcastro@unicauca.edu.co)
 */

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    IUserService userService;

    /**
     * @brief Metodo de crear un usuario
     * @param user Usuario creado
     * @return usuario creado
     */
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public User create(@RequestBody User user) {
        System.out.println("USUARIO CREADO");
        //System.out.println("Nombre usuario: "+user.getUserName());
        //System.out.println("Roles usuario: "+user.getUserRoles().get(0));
        return userService.create(user);
    }

    /**
     * @brief Metodo de editar un usuario
     * @param id Id del usuario
     * @param user Usuario editado
     * @return usuario total editado
     */
    @RequestMapping(value = "{id}", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public User update(@PathVariable Long id, @RequestBody User user){
        return userService.update(id, user);
    }

    /**
     * @brief Metodo para borrar un usuario por id que llama al repositorio
     * @param id Id del usuario
     */
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    //@ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        userService.deleteById(id);
    }

    /**
     * @brief Metodo para encontrar usuarios con un rol especifico
     * @param roleName nombre del role especifico
     * @return Lista de usuarios con ese rol
     */
    @RequestMapping(value = "{role}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<User> findByRoleName(@PathVariable String role){
        return userService.findByRoleName(role);
    }

    /**
     * @brief Metodo para encontrar usuarios con rol diferente a Visitante_Registrado
     * @return Lista de usuarios diferentes de ese rol
     */
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<User> findDifferentRoleVisitor(){
        return (List<User>)userService.findDifferentRoleVisitor();
    }
}
