package com.b13.cartservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.b13.cartservice.dto.Cart;
import com.b13.cartservice.dto.GuestCart;
import com.b13.cartservice.dto.Product;

@Service
@Qualifier("guestCartService")
public class GuestCartService implements CartService{
	
	@Autowired GuestCart cart;

	@Override
	public Cart addOrModifyItem(Product product) {
		cart.addOrModifyProduct(product);
		return cart;
	}

	@Override
	public Cart bulkAddItem(List<Product> products) {
		// TODO add multiple items to cart at once
		return cart;
	}

	@Override
	public Cart removeItem(String productId) {
		cart.removeProduct(productId);
		return cart;
	}

	@Override
	public Cart getCart() {
		return cart;
	}
}
