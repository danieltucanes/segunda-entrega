package com.unicauca.clientuserhttpclient.access;

import com.unicauca.clientuserhttpclient.domain.entities.User;
import java.util.List;

public interface IUserRepository {

    public List<User> findDifferentRoleVisitor();

    User findById(Long id);

    public void create(User user);

    public void edit(Long id, User userUpdated);

    public void delete(Long id);

}
