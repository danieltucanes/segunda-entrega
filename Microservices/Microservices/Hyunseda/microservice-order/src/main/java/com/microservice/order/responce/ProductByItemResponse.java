package com.microservice.order.responce;

import com.microservice.order.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductByItemResponse {
    private int amount;
    private Product product;

}
