package com.shoppingcart.app.service;


import com.shoppingcart.app.entity.Cart;
import com.shoppingcart.app.entity.Product;

public interface ICartService {


    /**
     *
     * @param id
     * @return
     */
    Cart retrieveCartById(Long id);


    /**
     *
     * @param cart
     */
    void createCart(Cart cart);


    /**
     *
     * @param cartId
     * @param product
     */
    Cart addProduct(String cartId, Product product);


}
