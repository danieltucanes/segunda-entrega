package com.unicauca.domain.service;

import com.unicauca.access.IUserRepository;
import com.unicauca.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @brief Implementacion de la interfaz de IUserService
 * @author Andres Felipe Castro (andresfcastro@unicauca.edu.co)
 */

@Service
public class UserServiceImp implements IUserService{

    /**
     * Inyección de IUserRepository
     */
    @Autowired
    private IUserRepository userRepository;

    /**
     * @brief Metodo de encontrar un usuario por id que llama al repositorio
     * @param id Id del usuario
     * @return usuario con la id
     */
    @Override
    @Transactional
    public User findById(Long id){
        return userRepository.findById(id).orElse(null);
    }

    /**
     * @brief Metodo de crear un usuario que llama al repositorio
     * @param user Usuario creado
     * @return usuario creado
     */
    @Override
    @Transactional
    public User create(User user){
        return userRepository.save(user);
    }

    /**
     * @brief Metodo de editar un usuario que llama al repositorio
     * @param id Id del usuario
     * @param user Usuario editado
     * @return usuario total editado
     */
    @Override
    @Transactional
    public User update(Long id, User user){
        User userChanged = this.findById(id);
        userChanged.setUserEmail(user.getUserEmail());
        userChanged.setUserName(user.getUserName());
        userChanged.setUserPassword(user.getUserPassword());
        userChanged.setUserRoles(user.getUserRoles());
        return userRepository.save(userChanged);
    }

    /**
     * @brief Metodo para borrar un usuario por id que llama al repositorio
     * @param id Id del usuario
     */
    @Override
    @Transactional
    public void deleteById(Long id){
        userRepository.deleteById(id);
    }

    /**
     * @brief Metodo para encontrar usuarios con un rol especifico que llama al repositorio
     * @param roleName nombre del role especifico
     * @return Lista de usuarios con ese rol
     */
    @Override
    @Transactional
    public List<User> findByRoleName(String roleName){
        return userRepository.findByRoleName(roleName);
    }

    /**
     * @brief Metodo para encontrar usuarios con rol diferente a Visitante_Registrado que llama al repositorio
     * @return Lista de usuarios diferentes de ese rol
     */
    @Override
    @Transactional
    public List<User> findDifferentRoleVisitor(){
        return userRepository.findDifferentRoleVisitor();
    }
}
