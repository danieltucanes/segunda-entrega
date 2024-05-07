package com.unicauca.clientuserhttpclient.domain.services;

import com.unicauca.clientuserhttpclient.domain.entities.User;
import java.util.List;
import com.unicauca.clientuserhttpclient.access.IUserRepository;

public class UserService {

    IUserRepository repo;

    public UserService(IUserRepository repo) {
        this.repo = repo;
    }

    public List<User> findDifferentRoleVisitor(){
        return repo.findDifferentRoleVisitor();
    }
    
    public void create(User user){
        repo.create(user);
    }
    
    public User findById(Long id){
        return repo.findById(id);
    }
    
    public void edit(Long id, User userUpdated){
        repo.edit(id, userUpdated);
    }
    
    public void delete(Long id){
        repo.delete(id);
    }
}
