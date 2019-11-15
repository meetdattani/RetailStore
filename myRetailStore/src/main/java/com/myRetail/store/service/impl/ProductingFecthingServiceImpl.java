package com.myRetail.store.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myRetail.store.domain.Product;
import com.myRetail.store.domain.ProductDetail;
import com.myRetail.store.repository.ProductDetailRepository;
import com.myRetail.store.repository.ProductRepository;
import com.myRetail.store.resource.DetailedProduct;
import com.myRetail.store.service.ProductFetchingService;

@Service
public class ProductingFecthingServiceImpl implements ProductFetchingService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductDetailRepository productDetailRepository;

	@Override
	public Product getProduct(String id) {
		Optional<Product> product = productRepository.findById(id);
		if (product.isPresent())
			return product.get();
		return new Product();
	}

	@Override
	public Boolean deleteProduct(String id)  {
		if (productRepository.existsById(id)) {
			productRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public Boolean addProduct(Product product) {
		if (!productRepository.existsById(product.getProductId())) {
			productRepository.insert(product);
			return true;
		}
		return false;
	}

	@Override
	public Product updateProduct(Product product) {
		if (productRepository.existsById(product.getProductId())) {
			return productRepository.save(product);
		}
		return new Product();
	}

	@Override
	public DetailedProduct getDetailedProduct(String id) {
		Optional<Product> product = productRepository.findById(id);
		Optional<ProductDetail> productDetail = productDetailRepository.findById(id);
		if (product.isPresent() && productDetail.isPresent()) {
			return new DetailedProduct(product.get().getProductId(),product.get().getProductPrice(), productDetail.get().getProductDescription());
		}

		return new DetailedProduct();
	}

}
