package com.b13.cartservice.dto;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import lombok.Builder;
import lombok.Data;

@Component
@SessionScope
@Data
@Builder
public class GuestCart extends Cart {
	
}
