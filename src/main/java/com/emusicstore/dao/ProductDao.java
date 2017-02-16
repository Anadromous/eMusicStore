package com.emusicstore.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.emusicstore.model.Product;

public class ProductDao {

	private List<Product> productList;
	
	public List<Product> getProductList(){
		Product product1 = new Product();
		product1.setProductId("P1");
		product1.setProductName("Guitar");
		product1.setProductCategory("Instrument");
		product1.setProductCondition("New");
		product1.setProductDescription("Really nice guitar");
		product1.setProductPrice(new Double(1200));
		product1.setProductManufacturer("Stratocaster");
		product1.setUnitInStock(3);
		
		Product product2 = new Product();
		product2.setProductId("P2");
		product2.setProductName("Record");
		product2.setProductCategory("Record");
		product2.setProductCondition("New");
		product2.setProductDescription("Really great Record");
		product2.setProductPrice(new Double(12.00));
		product2.setProductManufacturer("Sony");
		product2.setUnitInStock(3);
		
		Product product3 = new Product();
		product3.setProductId("P3");
		product3.setProductName("Speaker");
		product3.setProductCategory("Accesories");
		product3.setProductCondition("New");
		product3.setProductDescription("Polk shelf speaker");
		product3.setProductPrice(new Double(32));
		product3.setProductManufacturer("Polk Audio");
		product3.setUnitInStock(3);
		
		productList = new ArrayList<Product>();
		productList.add(product1);
		productList.add(product2);
		productList.add(product3);
		
		return productList;
		
	}

	public Product getProductById(String productId) throws IOException {
		for(Product product : getProductList()){
			if(product.getProductId().equals(productId)){
				return product;
			}
		}
		throw new IOException("No product found!");
	}
}
