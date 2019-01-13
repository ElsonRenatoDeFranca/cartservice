package com.shoppingcart.app.service;

import com.shoppingcart.app.entity.Product;

public interface IProductService {

    public Product getProductById(Long productId);
}
