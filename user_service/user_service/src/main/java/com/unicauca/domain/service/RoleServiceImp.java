package com.unicauca.domain.service;

import com.unicauca.access.IRoleRepository;
import com.unicauca.domain.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @brief Implementacion de la interfaz de IRoleService
 * @author Andres Felipe Castro (andresfcastro@unicauca.edu.co)
 */

@Service
public class RoleServiceImp implements IRoleService{

    /**
     * Inyección de IRoleRepository
     */
    @Autowired
    IRoleRepository roleRepository;


    /**
     * @brief Metodo de listar roles que llama al repositorio
     * @return Lista de todos los roles
     */
    @Override
    @Transactional
    public List<Role> findAll() {
        return (List<Role>) roleRepository.findAll();
    }
}
