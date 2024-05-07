package com.microservice.product.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "categories")

public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;
    private String name;

   // public Category(Long categoryId) {
   //     this.categoryId = categoryId;
    //}

    /*
    @ManyToMany
    @JoinTable(name = "producto_categoria",
            joinColumns = @JoinColumn(name = "productoId"),
            inverseJoinColumns = @JoinColumn(name = "categoryId"))
    private List<Product> products = new ArrayList<>();

     */
    @JsonIgnore
    @ManyToMany(mappedBy = "categories")
    private List<Product> products = new ArrayList<>();
}
