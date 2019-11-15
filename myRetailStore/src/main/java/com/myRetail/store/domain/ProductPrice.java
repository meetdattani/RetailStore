package com.myRetail.store.domain;

public class ProductPrice {

	private Double value;
	private String currency;
	
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public ProductPrice(Double value, String currency) {
		super();
		this.value = value;
		this.currency = currency;
	}
	
	
}
