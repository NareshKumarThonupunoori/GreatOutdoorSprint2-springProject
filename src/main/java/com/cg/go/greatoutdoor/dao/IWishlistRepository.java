package com.cg.go.greatoutdoor.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.go.greatoutdoor.entity.WishlistItemEntity;




public interface IWishlistRepository extends JpaRepository<WishlistItemEntity,Integer>{
	//List<WishlistItemEntity> findAll();

	List<WishlistItemEntity> findByUserId(int userId);

	//WishlistItemEntity findWishlistItem(String productId, String userId);
	//void addProductToWishlist(String prodId,long wishlistID);
	//void deleteWishlistItem(String productId, String userId);

	//void deleteWishlistByUserId(String userId) throws WishlistException;

	//WishlistItemEntity addWishlistItem(WishlistItemEntity wishlistItem);

	
}

