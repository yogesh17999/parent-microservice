package com.productservice.productservice.service;

import com.productservice.productservice.dto.ResponseDto;
import com.productservice.productservice.entity.Product;

import java.util.List;

public interface ProductService {

    public Product saveProduct(Product product);

    public List<Product> getAllProducts();
}
