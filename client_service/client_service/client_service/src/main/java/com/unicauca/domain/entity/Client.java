package com.unicauca.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "clients")

public class Client extends User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String address;

}
