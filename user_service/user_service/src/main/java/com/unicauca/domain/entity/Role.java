package com.unicauca.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

/**
 * @brief Representa un rol que es incluido en la base de datos y va asociado con el usuario
 * @author Andres Felipe Castro (andresfcastro@unicauca.edu.co)
 */
@Entity
@Table(name = "rol")
public class Role {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long roleId;

    @Column(name = "role_name")
    private String roleName;


}
