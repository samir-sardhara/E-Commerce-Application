package com.example.ProductService.services;

import com.example.ProductService.expections.ProductNotFoundExceptions;
import com.example.ProductService.models.Product;

import java.util.List;

public interface ProductService {
    Product getSingleProduct(long id) throws ProductNotFoundExceptions;
    List<Product> getAllProducts();
    Product createProduct(String title,String description,String image,String category,double price);
}
