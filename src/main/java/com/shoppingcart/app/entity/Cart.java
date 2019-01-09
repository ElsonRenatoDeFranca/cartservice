package com.shoppingcart.app.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity(name = "CART")
@Data
public class Cart {

    @Id
    @Column(name = "CART_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "CART_DESCRIPTION", length = 50)
    private String cartDescription;

    @OneToMany(mappedBy = "cartId", targetEntity = Product.class,fetch=FetchType.LAZY, cascade = CascadeType.ALL )
    private List<Product> products;

}