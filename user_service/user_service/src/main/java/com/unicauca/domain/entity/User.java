package com.unicauca.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

/**
 * @brief Representa un usuario que es incluido en la base de datos
 * @author Andres Felipe Castro (andresfcastro@unicauca.edu.co)
 */

@Entity
@Table(name = "usuario")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "user_password")
    private String userPassword;

    @ManyToMany(targetEntity = Role.class, fetch = FetchType.LAZY)
    private List<Role> userRoles = new ArrayList<>();
}
