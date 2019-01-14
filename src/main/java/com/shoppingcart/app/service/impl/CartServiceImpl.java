package com.shoppingcart.app.service.impl;

import com.shoppingcart.app.entity.Cart;
import com.shoppingcart.app.entity.Product;
import com.shoppingcart.app.repository.CartRepository;
import com.shoppingcart.app.service.ICartService;
import com.shoppingcart.app.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements ICartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private IProductService productService;

    private List<Product> products = new ArrayList<>();

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
            products.add(productResult);
        }
        cart.setProducts(products);

        cartRepository.save(cart);

        return cart;
    }

}