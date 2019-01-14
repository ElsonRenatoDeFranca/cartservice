package com.shoppingcart.app.service.impl;

import com.shoppingcart.app.entity.Cart;
import com.shoppingcart.app.entity.Product;
import com.shoppingcart.app.repository.CartRepository;
import com.shoppingcart.app.service.ICartService;
import com.shoppingcart.app.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CartServiceImpl implements ICartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private IProductService productService;

    @Override
    public Cart retrieveCartById(Long id) {
        return cartRepository.findById(id).get();
    }

    @Override
    public void createCart(Cart cart) {
        cartRepository.save(cart);
    }

    @Override
    @Transactional
    public Cart addProduct(String cartId, Product product) {

        Product productResult = productService.getProductById(product.getId());
        Cart cart = retrieveCartById(Long.parseLong(cartId));

        if(productResult != null){
            cart.getProducts().add(productResult);
        }
        cartRepository.save(cart);

        return cart;
    }

}