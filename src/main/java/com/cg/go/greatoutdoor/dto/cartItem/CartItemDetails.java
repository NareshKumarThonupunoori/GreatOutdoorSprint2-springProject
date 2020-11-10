package com.cg.go.greatoutdoor.dto.cartItem;

import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Id;

import com.cg.go.greatoutdoor.entity.ProductEntity;

public class CartItemDetails {
	@Id
	private Integer cartId;
	private Integer userId;
	//@OneToMany(cascade = {CascadeType.ALL})	
	@ElementCollection
	private Map<ProductEntity, Integer> products ;// product ,quantity
	private double cartTotalPrice;
	private Integer totalQuantity;
	
	
	
	public CartItemDetails(Integer cartId,Integer userId, double cartTotalPrice,Map<ProductEntity, Integer> products, Integer totalQuantity) {
		
		this.cartId=cartId;
		this.userId = userId;
		this.cartTotalPrice = cartTotalPrice;
		this.products = products;
		this.totalQuantity = totalQuantity;
	}
	public CartItemDetails() {
		 
	}
	public Integer getCartId() {
		return cartId;
	}
	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Map<ProductEntity, Integer> getProducts() {
		return products;
	}
	public void setProducts(Map<ProductEntity, Integer> products) {
		this.products = products;
	}
	public double getCartTotalPrice() {
		return cartTotalPrice;
	}
	public void setCartTotalPrice(double cartTotalPrice) {
		this.cartTotalPrice = cartTotalPrice;
	}
	public Integer getTotalQuantity() {
		return totalQuantity;
	}
	public void setTotalQuantity(Integer totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	
}
