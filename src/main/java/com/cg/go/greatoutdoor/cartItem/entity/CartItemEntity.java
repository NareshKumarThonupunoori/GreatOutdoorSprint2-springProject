package com.cg.go.greatoutdoor.cartItem.entity;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.cg.go.greatoutdoor.product.entity.ProductEntity;

import java.util.Map;
import java.util.Objects;

@Entity
public class CartItemEntity {
	@GeneratedValue
	@Id
	private Integer cartId;
	private Integer userId;
	@ElementCollection
	private Map<ProductEntity, Integer> products ;// product ,quantity
	private double cartTotalPrice;
	private long totalQuantity;
	
	
	
	public CartItemEntity(Integer userId, Map<ProductEntity, Integer> products, double cartTotalPrice,
			long totalQuantity) {
		
		this.userId = userId;
		this.products = products;
		this.cartTotalPrice = cartTotalPrice;
		this.totalQuantity = totalQuantity;
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
	public long getTotalQuantity() {
		return totalQuantity;
	}
	public void setTotalQuantity(long totalQuantity) {
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