package com.myRetail.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myRetail.store.Util.ServiceConstants;
import com.myRetail.store.Util.ValidationUtil;
import com.myRetail.store.domain.Product;
import com.myRetail.store.service.ProductFetchingService;

@RestController
@CrossOrigin
@RequestMapping(value = "/myRetail/product", produces = { "application/json" })
public class ProductDetailController {

	@Autowired
	private ProductFetchingService productService;

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getproduct(@PathVariable String id) {
		try {
			if (!ValidationUtil.validateId(id))
				return new ResponseEntity<>(ServiceConstants.CN_INVALID_ID, HttpStatus.NOT_ACCEPTABLE);
			return new ResponseEntity<>(productService.getProduct(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(ServiceConstants.CN_INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "detail/get/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getDetailedproduct(@PathVariable String id) {
		try {
			if (!ValidationUtil.validateId(id))
				return new ResponseEntity<>(ServiceConstants.CN_INVALID_ID, HttpStatus.NOT_ACCEPTABLE);
			return new ResponseEntity<>(productService.getDetailedProduct(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(ServiceConstants.CN_INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<?> addProduct(@RequestBody Product product) {
		try {
			if (productService.addProduct(product))
				return new ResponseEntity<>(ServiceConstants.CN_CREATED, HttpStatus.CREATED);
			return new ResponseEntity<>(ServiceConstants.CN_FAILED, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<>(ServiceConstants.CN_INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}

	@RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteProduct(@PathVariable String id) {
		try {
			if (!ValidationUtil.validateId(id))
				return new ResponseEntity<>(ServiceConstants.CN_INVALID_ID, HttpStatus.NOT_ACCEPTABLE);
			if (productService.deleteProduct(id))
				return new ResponseEntity<>(ServiceConstants.CN_DELETED, HttpStatus.OK);
			return new ResponseEntity<>(ServiceConstants.CN_FAILED, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<>(ServiceConstants.CN_INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateProduct(@PathVariable String id, @RequestBody Product product) {
		try {
			if (!ValidationUtil.validateId(id))
				return new ResponseEntity<>(ServiceConstants.CN_INVALID_ID, HttpStatus.NOT_ACCEPTABLE);
			return new ResponseEntity<>(productService.updateProduct(product), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(ServiceConstants.CN_INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
