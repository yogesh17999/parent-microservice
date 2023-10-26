package com.productservice.productservice.controller;

import com.productservice.productservice.dto.ProductRequestDto;
import com.productservice.productservice.dto.ResponseDto;
import com.productservice.productservice.mapper.ProductMapper;
import com.productservice.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("public/api/")
public class ProductController {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductService productService;

    @PostMapping("/product")
    @ResponseStatus(HttpStatus.CREATED)
    @SneakyThrows
    public ResponseDto createProduct(@RequestBody ProductRequestDto productRequestDto) {
            return ResponseDto.builder().message("Product Successfully added!!").status(HttpStatus.CREATED.value()).Data(productMapper.toDto(productService.saveProduct(productMapper.toEntity(productRequestDto)))).build();
    }

    @GetMapping("product/list")
    @ResponseStatus(HttpStatus.OK)
    @SneakyThrows
    public  ResponseDto getAllProducts() {
            return ResponseDto.builder().message("Success!!").status(HttpStatus.OK.value()).Data(productMapper.toListOfDto(productService.getAllProducts())).build();
    }
}
