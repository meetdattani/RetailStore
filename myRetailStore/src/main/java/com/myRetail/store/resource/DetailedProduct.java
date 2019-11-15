package com.myRetail.store.resource;

import com.myRetail.store.domain.Product;
import com.myRetail.store.domain.ProductPrice;

public class DetailedProduct extends Product{

	private String productDescription;

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public DetailedProduct(String productId,ProductPrice productPrice,String productDescription) {
		super(productId,productPrice);
		this.productDescription = productDescription;
	}

	public DetailedProduct() {
	}
	
	
	
	
}
