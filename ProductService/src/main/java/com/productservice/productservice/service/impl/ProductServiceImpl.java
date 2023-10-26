package com.productservice.productservice.service.impl;

import com.productservice.productservice.dto.ProductResponseDto;
import com.productservice.productservice.dto.ResponseDto;
import com.productservice.productservice.entity.Product;
import com.productservice.productservice.repository.ProductRepository;
import com.productservice.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
