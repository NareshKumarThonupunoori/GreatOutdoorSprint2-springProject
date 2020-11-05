package com.cg.go.greatoutdoor.cartItem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.go.greatoutdoor.cartItem.dao.ICartItemRepository;
import com.cg.go.greatoutdoor.cartItem.entity.CartItemEntity;
import com.cg.go.greatoutdoor.product.entity.ProductEntity;
import com.cg.go.greatoutdoor.product.exception.ProductException;

@Service
public class CartServiceImpl implements ICartService{
	
	
	@Autowired
	private ICartItemRepository daoCart;

	@Override
	public List<CartItemEntity> findCartlist(Integer userId) {
		List<CartItemEntity> list=daoCart.findByUserId(userId);
		return list;
	}

	@Override
	public CartItemEntity addCart(CartItemEntity cartItemEntity) {
		boolean exists=cartItemEntity.getCartId()!=null && daoCart.existsById(cartItemEntity.getCartId());
        if(exists){
            throw new ProductException("Cart already exists for id="+cartItemEntity.getCartId());
        }
        CartItemEntity cartItem=daoCart.save(cartItemEntity);
		return cartItem;
	}

	@Override
	public CartItemEntity updateCart(CartItemEntity cartItemEntity) {
		boolean exists=cartItemEntity.getCartId()!=null && daoCart.existsById(cartItemEntity.getCartId());
        if(!exists){
            throw new ProductException("Cart does not exists for id="+cartItemEntity.getCartId());
        }
        CartItemEntity cartItem=daoCart.save(cartItemEntity);
		return cartItem;
	}

	@Override
	public void deleteCartlist(Integer userId) {
		List<CartItemEntity> list=findCartlist(userId);
		for(CartItemEntity cartItem:list) {
			daoCart.delete(cartItem);
		}
	}
	
	@Override
	public void deleteCartItem(Integer cartId, Integer productId) {
		
	}

	@Override
	public CartItemEntity findCartItem(Integer productId, Integer userId) {
		/*List<CartItemEntity> list=findCartlist(userId);
		for(CartItemEntity cartItem:list) {
			Map<ProductEntity,Integer> map=cartItem.getProducts();
			
		}
		*/
		return null;
	}

}
