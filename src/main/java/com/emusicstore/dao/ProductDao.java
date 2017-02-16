package com.emusicstore.dao;

import java.util.List;

import com.emusicstore.model.Product;

public interface ProductDao {
	
	void addProduct(Product product);
	List<Product> getAllProducts();
	void deleteProduct(Integer id);
	Product getProductById(Integer id);

}
