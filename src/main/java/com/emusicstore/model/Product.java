package com.emusicstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

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
    private MultipartFile productImage;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public Integer getProductId() {
		return productId;
	}
	/**
	 * @return the productName
	 */
	@Column(name="product_name")
	@NotEmpty (message = "The product name must not be null.")
	public String getProductName() {
		return productName;
	}
	/**
	 * @return the productCategory
	 */
	@Column(name="category")
	public String getProductCategory() {
		return productCategory;
	}
	/**
	 * @return the productDescription
	 */
	@Column(name="description")
	public String getProductDescription() {
		return productDescription;
	}
	/**
	 * @return the productPrice
	 */
	@Column(name="price")
	@Min(value = 0, message = "The product price must no be less then zero.")
	public Double getProductPrice() {
		return productPrice;
	}
	/**
	 * @return the productCondition
	 */
	@Column(name="product_condition")
	public String getProductCondition() {
		return productCondition;
	}
	/**
	 * @return the productStatus
	 */
	@Column(name="status")
	public String getProductStatus() {
		return productStatus;
	}
	/**
	 * @return the unitInStock
	 */
	@Column(name="in_stock")
	@Min(value = 0, message = "The product unit must not be less than zero.")
	public int getUnitInStock() {
		return unitInStock;
	}
	/**
	 * @return the productManufacturer
	 */
	@Column(name="manufacturer")
	public String getProductManufacturer() {
		return productManufacturer;
	}
	
	@Transient
	public MultipartFile getProductImage() {
		return productImage;
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
	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}
	
	
}
