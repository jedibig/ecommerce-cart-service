package com.b13.cartservice.service;

import java.util.List;

import com.b13.cartservice.dto.Cart;
import com.b13.cartservice.dto.Product;

public interface CartService {
	Cart addOrModifyItem(Product product);
	
	Cart bulkAddItem(List<Product> products);
	
	Cart removeItem(String productId);
		
	Cart getCart();
}
