package com.cg.go.greatoutdoor.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.cg.go.greatoutdoor.dto.cartItem.CreateCartItemRequest;
import com.cg.go.greatoutdoor.dto.cartItem.UpdateCartItemRequest;
import com.cg.go.greatoutdoor.entity.CartItemEntity;
import com.cg.go.greatoutdoor.entity.ProductEntity;

@Component
public class CartItemUtil {
	
	public CartItemEntity convertToCartItem(CreateCartItemRequest cartItem) {
	
		Integer totalQuantity=0;
		double totalPrice=0;
		
		CartItemEntity cart=new CartItemEntity();
		cart.setUserId(cartItem.getUserId());
		Map<ProductEntity,Integer> products=new HashMap<>();
		List<ProductEntity> productList=cartItem.getProductList();
		for(ProductEntity product:productList) {
			totalQuantity+=product.getQuantity();
			totalPrice+=product.getPrice()*product.getQuantity();
			products.put(product,product.getQuantity());
		}
		cart.setProducts(products);
		cart.setCartTotalPrice(totalPrice);
		cart.setTotalQuantity(totalQuantity);
		return cart;
	}

	public CartItemEntity convertToCartItem(UpdateCartItemRequest cartItem) {
		Integer totalQuantity=0;
		double totalPrice=0;
		CartItemEntity cart=new CartItemEntity();
		cart.setUserId(cartItem.getUserId());
		Map<ProductEntity,Integer> products=new HashMap<>();
		List<ProductEntity> productList=cartItem.getProductList();
		for(ProductEntity product:productList) {
			totalQuantity+=product.getQuantity();
			totalPrice+=product.getPrice()*product.getQuantity();
			products.put(product,product.getQuantity());
		}
		cart.setProducts(products);
		cart.setCartTotalPrice(totalPrice);
		cart.setTotalQuantity(totalQuantity);
		return cart;
	}
}
