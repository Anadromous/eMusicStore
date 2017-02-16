package com.emusicstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity()
public class Product {
	
	private Integer productId;
	private String productName;
	private String productCategory;
	private String productDescription;
	private Double productPrice;
	private String productCondition;
	private String productStatus;
	private int unitInStock;
	private String productManufacturer;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public Integer getProductId() {
		return productId;
	}
	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * @return the productCategory
	 */
	public String getProductCategory() {
		return productCategory;
	}
	/**
	 * @return the productDescription
	 */
	public String getProductDescription() {
		return productDescription;
	}
	/**
	 * @return the productPrice
	 */
	public Double getProductPrice() {
		return productPrice;
	}
	/**
	 * @return the productCondition
	 */
	public String getProductCondition() {
		return productCondition;
	}
	/**
	 * @return the productStatus
	 */
	public String getProductStatus() {
		return productStatus;
	}
	/**
	 * @return the unitInStock
	 */
	public int getUnitInStock() {
		return unitInStock;
	}
	/**
	 * @return the productManufacturer
	 */
	public String getProductManufacturer() {
		return productManufacturer;
	}
	
	
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * @param productCategory the productCategory to set
	 */
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	/**
	 * @param productDescription the productDescription to set
	 */
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	/**
	 * @param productPrice the productPrice to set
	 */
	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}
	/**
	 * @param productCondition the productCondition to set
	 */
	public void setProductCondition(String productCondition) {
		this.productCondition = productCondition;
	}
	/**
	 * @param productStatus the productStatus to set
	 */
	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}
	/**
	 * @param unitInStock the unitInStock to set
	 */
	public void setUnitInStock(int unitInStock) {
		this.unitInStock = unitInStock;
	}
	/**
	 * @param productManufacturer the productManufacturer to set
	 */
	public void setProductManufacturer(String productManufacturer) {
		this.productManufacturer = productManufacturer;
	}
	
	

}
