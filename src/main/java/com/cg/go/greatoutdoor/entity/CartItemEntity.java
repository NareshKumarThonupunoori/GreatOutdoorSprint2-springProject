package com.cg.go.greatoutdoor.entity;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Map;
import java.util.Objects;

@Table(name="cartItem")
@Entity
public class CartItemEntity {
	@GeneratedValue
	@Id
	private Integer cartId;
	private Integer userId;
	//@OneToMany(cascade = {CascadeType.ALL})
	@ElementCollection
	private Map<ProductEntity, Integer> products ;// product ,quantity
	private double cartTotalPrice;
	private Integer totalQuantity;
	
	
	
	public CartItemEntity(Integer userId, double cartTotalPrice, Map<ProductEntity,Integer> products,double totalPrice,Integer quantity) {
		
		this.userId = userId;
		this.products = products;
		this.cartTotalPrice = totalPrice;
		this.totalQuantity = quantity;
	}
	public CartItemEntity() {
		 
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
	@Override
	public int hashCode() {
		int hash=Objects.hashCode(cartId);
		return hash;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartItemEntity other = (CartItemEntity) obj;
		if (cartId != other.cartId)
			return false;
		return true;
	}
}