package com.b13.cartservice.dto;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javassist.expr.NewArray;
import lombok.Data;

@Data
public abstract class Cart {
	
	@JsonDeserialize(using = ProductsDeseralizer.class)
	@JsonSerialize(using = ProductSerializer.class)
	private Map<String, Product> products = new HashMap<String, Product>();
	
//	private List<Product> products = new ArrayList<Product>();

	
	private BigDecimal totalPrice = BigDecimal.ZERO;
	

	
	static class ProductsDeseralizer extends JsonDeserializer<Map<String, Product>>{

		@Override
		public Map<String, Product> deserialize(JsonParser p, DeserializationContext ctxt)
				throws IOException, JsonProcessingException {
			Map<String, Product> map = new HashMap<String, Product>();
			
			p.nextToken();

			
			p.readValuesAs(Product.class).forEachRemaining(prod -> {
				map.put(prod.getProdutcId(), prod);
			});;
		
			return map;
		}
		
	}
	
	static class ProductSerializer extends JsonSerializer<Map<String, Product>>{

		@Override
		public void serialize(Map<String, Product> value, JsonGenerator gen, SerializerProvider serializers)
				throws IOException {
			gen.writeObject(value.values());
		}
		
	}
	
	public void updatePrice() {
		System.out.println(products);
		totalPrice = products.values().stream()
//		products.stream()
				.map(product -> product.getPrice()
						.multiply(BigDecimal.valueOf(
								product.getQuantity())))
				.reduce(BigDecimal.ZERO, BigDecimal::add);
	}
	
	public void addOrModifyProduct(Product product) {
		this.products.put(product.getProdutcId(), product);
//		int index = products.indexOf(product);
//		if (index == -1)
//			products.add(product);
//		else
//			products.add(index, product);
		updatePrice();
	}
	
	public void removeProduct(String productId) {
		this.products.remove(productId);
		updatePrice();
	}
	
}
