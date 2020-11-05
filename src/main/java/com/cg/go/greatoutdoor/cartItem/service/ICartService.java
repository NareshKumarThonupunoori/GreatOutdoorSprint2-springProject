package com.cg.go.greatoutdoor.cartItem.service;
import java.util.List;

import com.cg.go.greatoutdoor.cartItem.entity.CartItemEntity;

public interface ICartService {
	
	public List<CartItemEntity> findCartlist(Integer userId);

	public CartItemEntity findCartItem(Integer productId, Integer userId);

	public CartItemEntity addCart(CartItemEntity cartItemEntity);

	public CartItemEntity updateCart(CartItemEntity cartItemEntity);

	public void deleteCartItem(Integer cartId, Integer productId);

	public void deleteCartlist(Integer userId);

}
