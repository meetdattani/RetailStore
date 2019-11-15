package com.myRetail.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MyRetailStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyRetailStoreApplication.class, args);
	}

}
