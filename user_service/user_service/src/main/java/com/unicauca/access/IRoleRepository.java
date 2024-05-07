package com.unicauca.access;

import com.unicauca.domain.entity.Role;
import org.springframework.data.repository.CrudRepository;

/**
 * @brief Interfaz de repositorio de roles JPA
 * @author Andres Felipe Castro (andresfcastro@unicauca.edu.co)
 */
public interface IRoleRepository extends CrudRepository<Role, Long> {
}
