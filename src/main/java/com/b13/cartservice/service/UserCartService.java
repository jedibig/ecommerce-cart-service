package com.b13.cartservice.service;

import java.util.List;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.b13.cartservice.dto.Cart;
import com.b13.cartservice.dto.CartRepository;
import com.b13.cartservice.dto.Customer;
import com.b13.cartservice.dto.Product;
import com.b13.cartservice.dto.UserCart;

import lombok.Setter;

@Service
@Qualifier("userCartService")
@Setter
public class UserCartService implements CartService{
	
	@Autowired Customer customer;
	final CartRepository repository;
	

	@Override
	@CachePut(value  = "cart")
	@Transactional(value = TxType.REQUIRES_NEW)
	public Cart addOrModifyItem(Product product) {
		UserCart cart  = getCart();
				
		cart.getProducts().put(product.getProdutcId(), product);
		repository.save(cart);
		cart.updatePrice();
		
		return cart;
	}

	@Override
	public Cart bulkAddItem(List<Product> products) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@CachePut(value  = "cart")
	@Transactional(value = TxType.REQUIRES_NEW)
	public Cart removeItem(String productId) {
		UserCart cart  = getCart();
		
		cart.getProducts().remove(productId);
		repository.save(cart);
		
		cart.updatePrice();
		
		return cart;
	}

	@Override
	@Cacheable(value =  "cart")
	public UserCart getCart() {
		return repository.findById(customer.getCustomerId()).orElse(new UserCart(customer.getCustomerId()));
	}

	public UserCartService(CartRepository repository) {
		this.repository = repository;
	}
}
