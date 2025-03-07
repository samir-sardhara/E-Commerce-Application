package com.example.ProductService.dtos;

import com.example.ProductService.models.Category;
import com.example.ProductService.models.Product;

public class FakeStoreProductDto {
    private String title;
    private String description;
    private double price;
    private String image;
    private String category;

    public Product toProduct(){
        Product product = new Product();
        product.setDescription(description);
        product.setPrice(price);
        product.setImageUrl(image);
        product.setTitle(title);
        Category category1 = new Category();
        category1.setTitle(category);

        return  product;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
