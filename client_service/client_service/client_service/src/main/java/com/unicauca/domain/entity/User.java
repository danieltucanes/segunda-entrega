package com.unicauca.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class User {

    private Long id;
    private String username;
    private String email;
    private String password;

    private List<Role> roles = new ArrayList<>();
}
