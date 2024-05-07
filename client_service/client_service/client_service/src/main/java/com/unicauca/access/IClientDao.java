package com.unicauca.access;

import com.unicauca.domain.entity.Client;
import org.springframework.data.repository.CrudRepository;

/**
 * Interface DAO de clientes
 * @author
 *
 */
public interface IClientDao extends CrudRepository<Client, Long> {

}
