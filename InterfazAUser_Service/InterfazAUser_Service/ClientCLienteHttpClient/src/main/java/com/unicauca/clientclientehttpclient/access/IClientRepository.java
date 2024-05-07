/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.unicauca.clientclientehttpclient.access;

import com.unicauca.clientclientehttpclient.domain.entities.Client;
import com.unicauca.clientclientehttpclient.domain.entities.Role;
import com.unicauca.clientclientehttpclient.domain.entities.User;
import java.util.List;

/**
 *
 * @author Dell
 */
public interface IClientRepository {
    
    public List<Client> findAll();

    public Client findById(Long id);

    public void create(Client client, User user);

    public void update(Client client, Long id);

    public void deleteById(Long id);
    
    public List<Role> findAllRoles();
    
    public List<User> findByRoleName(String role);

}
