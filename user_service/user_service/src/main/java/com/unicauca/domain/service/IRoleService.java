package com.unicauca.domain.service;

import com.unicauca.domain.entity.Role;

import java.util.List;

/**
 * @brief Interfaz de operaciones de la bd de roles
 * @author Andres Felipe Castro (andresfcastro@unicauca.edu.co)
 */

public interface IRoleService {
    public List<Role> findAll();
}
