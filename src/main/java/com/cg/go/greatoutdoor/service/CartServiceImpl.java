package com.cg.go.greatoutdoor.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.go.greatoutdoor.dao.ICartItemRepository;
import com.cg.go.greatoutdoor.entity.CartItemEntity;
import com.cg.go.greatoutdoor.entity.ProductEntity;
import com.cg.go.greatoutdoor.exception.CartException;
import com.cg.go.greatoutdoor.exception.ProductException;

@Service
public class CartServiceImpl implements ICartService{
	
	
	@Autowired
	private ICartItemRepository cartRepository;

	@Override
	public List<CartItemEntity> findCartlist(Integer userId) {
		List<CartItemEntity> list=cartRepository.findByUserId(userId);
		return list;
	}

	@Override
	public CartItemEntity addCart(CartItemEntity cartItemEntity) {
		boolean exists=cartItemEntity.getCartId()!=null && cartRepository.existsById(cartItemEntity.getCartId());
        if(exists){
            throw new ProductException("Cart already exists for id="+cartItemEntity.getCartId());
        }
        CartItemEntity cartItem=cartRepository.save(cartItemEntity);
		return cartItem;
	}

	@Override
	public CartItemEntity updateCart(CartItemEntity cartItemEntity) {
		boolean exists=cartItemEntity.getCartId()!=null && cartRepository.existsById(cartItemEntity.getCartId());
        if(!exists){
            throw new CartException("Cart does not exists for id="+cartItemEntity.getCartId());
        }
        CartItemEntity cartItem=cartRepository.save(cartItemEntity);
		return cartItem;
	}

	@Override
	public void deleteCartlist(Integer userId) {
		List<CartItemEntity> list=findCartlist(userId);
		for(CartItemEntity cartItem:list) {
			cartRepository.delete(cartItem);
		}
	}
	
	@Override
	public void deleteCartItem(Integer cartId, Integer productId) {
		CartItemEntity cartItem=findById(cartId);
		Map<ProductEntity,Integer> products=cartItem.getProducts();
		ArrayList<ProductEntity> keyList=new ArrayList<>(products.keySet());
		for(ProductEntity key:keyList) {
			if(key.getProductId().equals(productId)) {
				products.remove(key);
			}
		}
	}

	private CartItemEntity findById(Integer cartId) {
		Optional<CartItemEntity> optional=cartRepository.findById(cartId);
		if(!optional.isPresent())
			throw new CartException("Cart does not exists for id="+cartId);
		CartItemEntity cartItemEntity=optional.get();
		return cartItemEntity;
	}

	@Override
	public CartItemEntity findCartItem(Integer productId, Integer userId) {
		List<CartItemEntity> list=findCartlist(userId);
		for(CartItemEntity cartItem:list) {
			Map<ProductEntity,Integer> map=cartItem.getProducts();
			ArrayList<ProductEntity> keyList=new ArrayList<>(map.keySet());
			for(ProductEntity key:keyList) {
				if(key.getProductId().equals(productId)) {
					return cartItem;
				}
			}
			
		}
		return null;
	}

}
