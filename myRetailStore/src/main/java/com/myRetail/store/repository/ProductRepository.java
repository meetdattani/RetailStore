package com.myRetail.store.repository;

import java.util.Optional;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.myRetail.store.domain.Product;


public interface ProductRepository extends MongoRepository<Product, String> {

	@Override
	@Cacheable(cacheNames = {"products"})
	public Optional<Product> findById(String id);
	
	@Override
	@CachePut(key = "#product.productId",cacheNames = {"products"})
	public Product insert(Product product);
	
	@Override
	@CacheEvict(cacheNames = {"products"}, key="#product.productId")
	public Product save(Product product);
	
	
}
