package com.productservice.productservice.mapper;

import com.productservice.productservice.dto.ProductRequestDto;
import com.productservice.productservice.dto.ProductResponseDto;
import com.productservice.productservice.entity.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    public Product toEntity(ProductRequestDto dto);

    public ProductResponseDto toDto(Product product);

    public List<ProductResponseDto> toListOfDto(List<Product> LallProducts);


}