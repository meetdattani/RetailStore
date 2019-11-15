package com.myRetail.store.service;

import com.myRetail.store.domain.Product;
import com.myRetail.store.resource.DetailedProduct;

public interface ProductFetchingService {

	public Product getProduct(String id);
	public Boolean deleteProduct(String id);
	public Boolean addProduct(Product product);
	public Product updateProduct(Product product);
	public DetailedProduct getDetailedProduct(String id);
}
