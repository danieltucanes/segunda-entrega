package com.unicauca.access;

import com.unicauca.domain.entity.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientRepository extends CrudRepository<Client, Long> {
}
