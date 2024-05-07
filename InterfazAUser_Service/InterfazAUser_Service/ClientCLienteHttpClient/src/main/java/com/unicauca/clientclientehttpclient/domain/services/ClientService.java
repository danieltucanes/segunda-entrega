/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unicauca.clientclientehttpclient.domain.services;

import com.unicauca.clientclientehttpclient.access.IClientRepository;
import com.unicauca.clientclientehttpclient.domain.entities.Client;
import com.unicauca.clientclientehttpclient.domain.entities.Role;
import com.unicauca.clientclientehttpclient.domain.entities.User;
import java.util.List;

/**
 *
 * @author Dell
 */
public class ClientService {
    IClientRepository repo;

    public ClientService(IClientRepository repo) {
        this.repo=repo;
    }


    public List<Client> findAll() {
        return repo.findAll();
    }
    
    public void create(Client client, User user){
        repo.create(client, user);
    }
    
    public Client findById(Long id){
        return repo.findById(id);
    }
    
    public void update(Long id, Client client){
        repo.update(client,id);
    }
    
    public void deleteById(Long id){
        repo.deleteById(id);
    }
    
    public List<Role> findAllRoles(){
        return repo.findAllRoles();
    }
    
    public List<User> findByRoleName(String role){
        return repo.findByRoleName(role);
    }
    
}
