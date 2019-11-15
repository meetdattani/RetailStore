package com.myRetail.store.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product {

	@Id
	private String productId;
	private ProductPrice productPrice;
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public ProductPrice getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(ProductPrice productPrice) {
		this.productPrice = productPrice;
	}
	public Product(String productId, ProductPrice productPrice) {
		super();
		this.productId = productId;
		this.productPrice = productPrice;
	}
	public Product() {
		super();
	}
	
	
	
	
}
