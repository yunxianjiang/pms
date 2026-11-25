package com.example.pms.mapper;

import com.example.pms.dto.ProductDto;
import com.example.pms.entity.Product;

public class ProductMapper {
    public static ProductDto mapToProductDto(Product product) {
        return new ProductDto(
                product.getId,
                product.getName,
                product.getPrice,
                product.getStock
        );
    }

    public static Product mapToProduct(ProductDto productDto) {
        return new Product(
                productDto.getId,
                productDto.getName,
                productDto.getPrice,
                productDto.getStock
        );
    }
}
