package com.b13.cartservice.dto;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<UserCart, String>{
	
}
