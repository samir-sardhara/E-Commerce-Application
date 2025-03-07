package com.example.ProductService.services;

import com.example.ProductService.expections.ProductNotFoundExceptions;
import com.example.ProductService.models.Category;
import com.example.ProductService.models.Product;

import com.example.ProductService.repository.CategoryRepository;
import com.example.ProductService.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
public class SelfProductService implements ProductService{
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository,CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;

    }
    @Override
    public Product getSingleProduct(long id)throws ProductNotFoundExceptions{
        Optional<Product> optionalProduct = productRepository.findById(id);

        if(optionalProduct.isEmpty()){
            //product with the given id doesn't exist
            //either you can throw an exception further or you handle it
            throw new ProductNotFoundExceptions("Product with the given id doesn't exist");
        }

        return optionalProduct.get();
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products;
    }

    @Override
    public Product createProduct(String title, String description, String image, String category, double price) {
        Product product = new Product();
        product.setTitle(title);
        product.setPrice(price);
        product.setDescription(description);
        product.setImageUrl(image);

        Category categeryFromDb = categoryRepository.findByTitle(title);

        if(categeryFromDb == null){
            Category newCatageory = new Category();
            newCatageory.setTitle(title);
            product.setCategory(newCatageory);
        }else{
            product.setCategory(categeryFromDb);
        }

        return  productRepository.save(product);

    }
}
