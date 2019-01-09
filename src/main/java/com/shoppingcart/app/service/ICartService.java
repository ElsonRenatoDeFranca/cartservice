package com.shoppingcart.app.service;


import com.shoppingcart.app.entity.Cart;

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

}
