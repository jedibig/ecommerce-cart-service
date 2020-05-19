package com.b13.cartservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.b13.cartservice.dto.Cart;
import com.b13.cartservice.dto.Product;
import com.b13.cartservice.dto.Customer;
import com.b13.cartservice.service.CartService;

@RestController
@RequestMapping("/customers/{customerId}/carts")
public class UserCartController{
	
	@Autowired
	@Qualifier("userCartService")
	CartService service;
	
	@Autowired
	Customer user;
	

	@GetMapping
	public Cart getCart(@PathVariable("customerId") String customerId) {
		user.setCustomerId(customerId);
		return service.getCart();
	}

	@PutMapping
	public Cart addOrModifyItem(@PathVariable("customerId") String customerId, Product products) {
		user.setCustomerId(customerId);
		return service.addOrModifyItem(products);
	}

	
	public Cart removeItem(@PathVariable("customerId") String customerId, @PathVariable(value = "productId") String productId) {
		user.setCustomerId(customerId);
		return service.removeItem(productId);
	}
}
