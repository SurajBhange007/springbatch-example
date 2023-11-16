package com.batch.config;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.batch.model.Product;

@Component
public class CustomerItemProcessor implements ItemProcessor<Product, Product>{

	@Override
	public Product process(Product item) throws Exception {
		try {
			double discount= Double.parseDouble(item.getDiscount());
			double price = Double.parseDouble(item.getPrice());
			double finalPrice = price * (100-discount)/100;
			item.setDiscountedPrice(String.valueOf(finalPrice));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return item;
	}

	
}
