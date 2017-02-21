package com.emusicstore.dao;

import java.util.List;

import com.emusicstore.model.Product;

public interface ProductDao {
	
    void addProduct(Product product);

    void editProduct(Product product);

    Product getProductById(Integer id);

    List<Product> getAllProducts();

    void deleteProduct(Integer id);
	

}
