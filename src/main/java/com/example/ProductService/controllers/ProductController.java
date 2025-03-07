package com.example.ProductService.controllers;

import com.example.ProductService.dtos.CreateProductDto;
import com.example.ProductService.expections.ProductNotFoundExceptions;
import com.example.ProductService.models.Product;
import com.example.ProductService.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private ProductService productService;
    public ProductController(@Qualifier("selfProductService") ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/product/{id}")
    Product getSingleProduct(@PathVariable("id") long id) throws ProductNotFoundExceptions {
        return productService.getSingleProduct(id);
    }

    @GetMapping("/product")
    List<Product> getAllProducts(){
        return null;
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody CreateProductDto createProductRequestDTO){
        return productService.createProduct(createProductRequestDTO.getTitle(),
                createProductRequestDTO.getDescription(),
                createProductRequestDTO.getImage(),
                createProductRequestDTO.getCategory(),
                createProductRequestDTO.getPrice());
    }

}
