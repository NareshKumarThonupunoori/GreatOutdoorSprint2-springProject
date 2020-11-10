package com.cg.go.greatoutdoor.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.go.greatoutdoor.dao.IWishlistRepository;
import com.cg.go.greatoutdoor.entity.WishlistItemEntity;
import com.cg.go.greatoutdoor.exception.WishlistException;
import com.cg.go.greatoutdoor.exception.WishlistNotFoundException;

@Transactional
@Service
public class WishlistServiceImpl  implements IWishlistService{
//private static final Logger Log = LoggerFactory.getLogger(ProductServiceImpl.class);
		
	@Autowired
	IWishlistRepository WishlistRepository;

	
     @Override
	public List<WishlistItemEntity> findAll() {
		
        List<WishlistItemEntity> list=WishlistRepository.findAll();
        return list;
	}

	@Override
	public List<WishlistItemEntity> findByUserId(int userId) {
		
	     List<WishlistItemEntity> list=WishlistRepository.findByUserId(userId);
	     if(list.size()==0) {
	    	 throw new WishlistNotFoundException("Wishlist not found for userId="+userId);
	     }
      	return list;
	}
	@Override
	public void deleteByUserId(int userId){
		
		List<WishlistItemEntity> wishlist= findByUserId(userId);
		for(WishlistItemEntity item : wishlist)
		{
			WishlistRepository.deleteById(item.getWishlistId());
		}
		
       
		
	}

	@Override
	public WishlistItemEntity addWishlistItem(WishlistItemEntity wishlistItem){
	//	if(wishlistItem==null){
		//	throw new WishlistException("invalid wishlistitem");
		//}
		boolean exists=wishlistItem.getWishlistId()!=null &&  WishlistRepository.existsById(wishlistItem.getWishlistId());
        if(exists){
            throw new WishlistException("Cart already exists for id="+wishlistItem.getUserId());
        }
        WishlistItemEntity wishlistObject=WishlistRepository.save(wishlistItem);
      
		return wishlistObject;
	}

	
	
	/*
	@Override
	public WishlistItemEntity findWishlistItem(String productId, String userId) {
	     WishlistItemEntity wishlistObject =WishlistRepository.findWishlistItem(productId,userId);
		return wishlistObject;
	}
	@Override
	public void addProductToWishlist(String prodId, long wishlistID) {
		//if(prodId==null||prodId.isEmpty()){
         //throw new Exception("productid is null or empty");
		//}
		
		WishlistRepository.addProductToWishlist(prodId, wishlistID );
        
      
		
	}
	@Override
	public void deleteWishlistItem(String productId, String userId) throws WishlistException {
		
		WishlistRepository.deleteWishlistItem(productId, userId);
      
	}
*/

}