package com.shoppingcart.app.service.impl;

import com.shoppingcart.app.entity.Cart;
import com.shoppingcart.app.repository.CartRepository;
import com.shoppingcart.app.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements ICartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public Cart retrieveCartById(Long id) {
        return cartRepository.findById(id).get();
    }

    @Override
    public void createCart(Cart cart) {
        cartRepository.save(cart);
    }

}