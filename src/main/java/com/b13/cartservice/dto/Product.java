package com.b13.cartservice.dto;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	public Product(String productId) {
		this.produtcId = productId;
	}
	private String produtcId;
	private int quantity;
	private BigDecimal price;
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Product other = (Product) obj;
		if (produtcId == null) {
			if (other.produtcId != null)
				return false;
		} else if (!produtcId.equals(other.produtcId))
			return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((produtcId == null) ? 0 : produtcId.hashCode());
		return result;
	}
	
	
}
