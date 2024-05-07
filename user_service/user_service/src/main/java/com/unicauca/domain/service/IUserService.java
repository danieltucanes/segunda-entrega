package com.unicauca.domain.service;

import com.unicauca.domain.entity.User;
import org.springframework.data.repository.query.Param;


import java.util.List;

/**
 * @brief Interfaz de operaciones de la bd de usuarios
 * @author Andres Felipe Castro (andresfcastro@unicauca.edu.co)
 */

public interface IUserService {

    public User findById(Long id); //Puede que no sea necesario este sino algo especifico + Puede que aqui se llamen a las excepciones como lo tiene el ejemplo Product-Service

    public User create(User user);

    public User update(Long id, User user);

    public void deleteById(Long id);

    public List<User> findByRoleName(String roleName);

    public List<User> findDifferentRoleVisitor();
}
