package com.cg.go.greatoutdoor.dto.cartItem;

import java.util.Map;

import javax.persistence.ElementCollection;

import com.cg.go.greatoutdoor.entity.ProductEntity;

public class CreateCartItemRequest {
	private Integer userId;
	//@ElementCollection
	//private Map<ProductEntity, Integer> products ;// product ,quantity
	private double cartTotalPrice;
	private long totalQuantity;
	
	
	
	public CreateCartItemRequest(Map<ProductEntity, Integer> products, double cartTotalPrice,
			long totalQuantity) {
		
		//this.products = products;
		this.cartTotalPrice = cartTotalPrice;
		this.totalQuantity = totalQuantity;
	}
	public CreateCartItemRequest() {
		 
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/*public Map<ProductEntity, Integer> getProducts() {
		return products;
	}
	public void setProducts(Map<ProductEntity, Integer> products) {
		this.products = products;
	}*/
	public double getCartTotalPrice() {
		return cartTotalPrice;
	}
	public void setCartTotalPrice(double cartTotalPrice) {
		this.cartTotalPrice = cartTotalPrice;
	}
	public long getTotalQuantity() {
		return totalQuantity;
	}
	public void setTotalQuantity(long totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	
}
