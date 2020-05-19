package com.b13.cartservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.b13.cartservice.dto.Cart;
import com.b13.cartservice.dto.Product;
import com.b13.cartservice.service.CartService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/carts")
public class GuestCartController {

	@Autowired
	@Qualifier("guestCartService")
	CartService service;
	
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Cart getCart() {
		return service.getCart();
	}
	
	@PutMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Cart addOrModifyItem(@RequestBody Product products){
		return service.addOrModifyItem(products);
	}
	
	@DeleteMapping("/products/{productId}")
	@ResponseStatus(code = HttpStatus.OK)
	public Cart removeItem(@PathVariable(value = "productId") String productId){
		return service.removeItem(productId);
	}


}
