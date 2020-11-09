package com.cg.go.greatoutdoor.dto.cartItem;

import java.util.List;
import javax.persistence.Id;

import com.cg.go.greatoutdoor.entity.ProductEntity;

public class UpdateCartItemRequest {
	@Id
	private Integer cartId;

	private Integer userId;
	List<ProductEntity> productList;
	
	public UpdateCartItemRequest( Integer userId, List<ProductEntity> productList) {

		this.userId = userId;
		this.productList = productList;
	}
	public UpdateCartItemRequest() {
		
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
	public List<ProductEntity> getProductList() {
		return productList;
	}
	public void setProductList(List<ProductEntity> productList) {
		this.productList = productList;
	}
	
}
