package com.legendary.coffeeShop.dao.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column(name = "product_type")
    private ProductType productType;

    @Column
    private List<Component> components;

    @Column
    private double price;


    public double getTotalProductPrice() {
        double totalProductPrice = price;
        for (Component component : components) {
            totalProductPrice += component.getPrice();
        }

        return totalProductPrice;
    }

}