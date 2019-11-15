package com.myRetail.store.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.myRetail.store.domain.ProductDetail;

public interface ProductDetailRepository extends MongoRepository<ProductDetail, String> {

}
