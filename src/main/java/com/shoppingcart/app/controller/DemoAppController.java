package com.shoppingcart.app.controller;


import com.shoppingcart.app.entity.Cart;
import com.shoppingcart.app.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(method=RequestMethod.POST, value=": /carts/{cartId}/products")
    public void addProductsToCart(@RequestBody Cart cart) {
        cartService.createCart(cart);
    }


}
