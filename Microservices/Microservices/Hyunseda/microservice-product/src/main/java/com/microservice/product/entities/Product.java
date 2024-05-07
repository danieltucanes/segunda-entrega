package com.microservice.product.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    private String name;

    private Double price;

    private String description;

    private String slug;

    private int stock;

    private String keywords;

    private String images;

    private String characteristics;

   // private Date createAt;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createAt;

    /*
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "categories")
    private List<Category> categorias = new ArrayList<>();*/
    //solucion


    @JsonIgnoreProperties("products")
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "product_category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories = new ArrayList<>();

}
