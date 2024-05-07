package com.microservice.order.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table (name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String state;

    @Column(name = "fechaOrden")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;


    @OneToMany(mappedBy = "order")
    private List<Item> items = new ArrayList<>();

    /*
    @ManyToOne
    @JoinColumn(name = "id_client", nullable = false)
    private Client client;
    */
}
