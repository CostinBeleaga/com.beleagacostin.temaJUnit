package com.example.Homework7.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany
    List<Product> productList;

    public Integer totalPrice() {
           Integer sum = 0;
           for(Product product : productList) {
               sum += product.getPrice();
           }
           return sum;
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public void removeProduct(Product product) {
        productList.remove(product);
    }

}
