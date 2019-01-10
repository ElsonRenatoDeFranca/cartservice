package com.shoppingcart.app.controller;


import com.shoppingcart.app.entity.Cart;
import com.shoppingcart.app.entity.Product;
import com.shoppingcart.app.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class DemoAppController {

    @Autowired
    private ICartService cartService;

    @RequestMapping(method=RequestMethod.GET,value="/carts/{cartId}")
    public Cart retrieveCartById(@PathVariable Long cartId){
        return cartService.retrieveCartById(cartId);
    }

    @RequestMapping(method=RequestMethod.POST, value="/carts")
    public void createCart(@RequestBody Cart cart) {
        cartService.createCart(cart);
    }


    @RequestMapping(method=RequestMethod.POST, value="/carts/{cartId}/products",produces = MediaType.APPLICATION_JSON_VALUE)
    public void addProductsToCart(@PathVariable(name="cartId") String cartId, @RequestBody Product product) {
        cartService.addProduct(cartId, product);;
    }


}
