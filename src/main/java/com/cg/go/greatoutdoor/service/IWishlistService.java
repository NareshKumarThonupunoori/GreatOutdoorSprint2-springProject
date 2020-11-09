package com.cg.go.greatoutdoor.service;

import java.util.List;

import com.cg.go.greatoutdoor.entity.WishlistItemEntity;



public interface IWishlistService {
	
	List<WishlistItemEntity> findAll();

	

	//WishlistItemEntity findWishlistItem(String productId, String userId);
	//void addProductToWishlist(String prodId,long wishlistID);
	//void deleteWishlistItem(int productId, String userId) throws WishlistException;

	void deleteByUserId(int userId) ;

	WishlistItemEntity addWishlistItem(WishlistItemEntity wishlistItem);

	List<WishlistItemEntity> findByUserId(int userId);

}