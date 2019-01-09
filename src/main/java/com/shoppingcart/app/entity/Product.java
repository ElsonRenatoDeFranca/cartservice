package com.shoppingcart.app.entity;

import lombok.Data;

import javax.persistence.Entity;

@Entity(name = "PRODUCT")
@Data
public class Product {

    private String id;
    private String description;
    private Double price;
}
