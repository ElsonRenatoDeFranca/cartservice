package com.shoppingcart.app.service.impl;

import com.shoppingcart.app.entity.Cart;
import com.shoppingcart.app.entity.Product;
import com.shoppingcart.app.repository.CartRepository;
import com.shoppingcart.app.service.ICartService;
import com.shoppingcart.app.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements ICartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private IProductService productService;

    @Override
    public Cart retrieveCartById(Long id) {
        Optional<Cart> cart = cartRepository.findById(id);
        return cart.get();
    }

    @Override
    public void createCart(Cart cart) {
        cartRepository.save(cart);
    }

    @Override
    public Cart addProduct(String cartId, Product product) {

        List<Product> products = new ArrayList<>();
        Product productResult = productService.getProductById(Long.parseLong(product.getId()));
        Cart cart = retrieveCartById(Long.parseLong(cartId));

        if(productResult != null){
            products.add(productResult);
        }
        cart.setProducts(products);

        return cart;
    }

}