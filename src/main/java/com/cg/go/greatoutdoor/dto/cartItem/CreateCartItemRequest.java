package com.cg.go.greatoutdoor.dto.cartItem;

import java.util.List;


import com.cg.go.greatoutdoor.entity.ProductEntity;

public class CreateCartItemRequest {
	
	private Integer userId;
	private List<ProductEntity> productList;
	public CreateCartItemRequest( Integer userId, List<ProductEntity> productList) {
		this.userId = userId;
		this.productList = productList;
	}
	public CreateCartItemRequest() {
		
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
