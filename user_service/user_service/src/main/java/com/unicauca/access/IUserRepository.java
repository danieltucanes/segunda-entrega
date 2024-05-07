package com.unicauca.access;

import com.unicauca.domain.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @brief Interfaz de repositorio de usuarios JPA
 * @author Andres Felipe Castro (andresfcastro@unicauca.edu.co)
 */
public interface IUserRepository extends CrudRepository<User, Long> {
    /**
     * @brief Metodo que incluye consulta para encontrar usuarios por un rol especifico
     */
    @Query(value = "SELECT * FROM userdb.usuario_user_roles j " +
            "INNER JOIN userdb.rol r ON j.user_roles_role_id = r.role_id " +
            "INNER JOIN userdb.usuario u ON j.user_user_id = u.user_id " +
            "WHERE r.role_name = :role", nativeQuery = true)
    List<User> findByRoleName(@Param("role") String roleName);

    /**
     * @brief Metodo que incluye consulta para encontrar usuarios que sean diferentes del rol Visitante_Registrado
     */
    @Query(value = "SELECT * FROM userdb.usuario_user_roles j " +
            "INNER JOIN userdb.rol r ON j.user_roles_role_id = r.role_id " +
            "INNER JOIN userdb.usuario u ON j.user_user_id = u.user_id " +
            "WHERE r.role_name != 'Visitante_Registrado'", nativeQuery = true)
    List<User> findDifferentRoleVisitor();
}