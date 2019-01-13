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

@Service
public class CartServiceImpl implements ICartService {

    @Autowired
    private CartRepository cartRepository;

    //@Autowired
    //public RestTemplate restTemplate;

    //private static final String PRODUCT_URL = "https://product-service.apps.dev.pcf-aws.com/products/";

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
    public Cart addProduct(String cartId, Product product) {

        //ResponseEntity<Product> responseEntity = this.restTemplate.exchange(PRODUCT_URL + product.getId(),HttpMethod.GET, new HttpEntity<>(new HttpHeaders()), Product.class);
        //Product productResult = responseEntity.getBody();
        List<Product> products = new ArrayList<>();
        Product productResult = productService.getProductById(Long.parseLong(product.getId()));

        Cart cart = retrieveCartById(Long.parseLong(cartId));
       // Cart cart = addProductToCart(productResult, cartId);


        if(productResult != null){
            products.add(productResult);
        }
        cart.setProducts(products);


        return cart;
    }

    /*
    private Cart addProductToCart(Product product, String cartId){

        List<Product> products = new ArrayList<>();
        Cart cart = retrieveCartById(Long.parseLong(cartId));


        if(product != null){
            products.add(product);
        }
        cart.setProducts(products);

        return cart;
    }
    */

    /*public Product findRemoteProduct(Long productId) {
            Optional<Product> productRemote = this.productRestClient.getResource(productURL + productId);
            return productRemote.orElseThrow( () -> new ResourceNotFoundException("Product not found", null));
    }*/

}