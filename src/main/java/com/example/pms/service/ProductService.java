package com.example.pms.service;

import com.example.pms.dto.ProducttDto;
import com.example.pms.entity.Product;
import com.example.pms.mapper.ProductMapper;
import com.example.pms.repository.ProductRepository;
import com.example.pms.exception.ResourceNotFoundException;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductService {
    private ProductService service;

    public ProductDto createProduct(ProductDto productDto) {
        Product product = ProductMapper.mapToProduct(producttDto);
        Product saved = productRepo.save(product);
        return ProductMapper.mapToProductDto(saved);
    }

    public ProductDto getProductById(Long productId) {
        Product product = productRepo.findById(productId).orElseThrow(
                () -> new ResourceNotFoundException("Not exist"));
        return ProductMapper.mapToProductDto(product);
    }

    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepo.findAll();
        return products.stream()
                .map(ProductMapper::mapToProductDto)
                .collect(Collectors.toList());
    }

    public ProductDto updateProduct(Long productId, ProductDto updatedProduct) {
        Product product = productRepo.findById(productId).orElseThrow(
                () -> new ResourceNotFoundException("Not exist"));
        product.setName(updatedProduct.getName());
        product.setPrice(updatedProduct.getPrice());
        product.setStock(updatedProduct.getStock());
        Product saved = productRepo.save(product);
        return ProductMapper.mapToProductDto(saved);
    }

    public void deleteProduct(Long productId) {
        Product product = productRepo.findById(productId).orElseThrow(
                () -> new ResourceNotFoundException("Not exist"));
        productRepo.delete(product);
    }
}
