package com.cg.go.greatoutdoor.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import com.cg.go.greatoutdoor.dto.wishlist.CreateWishlistItemRequest;
import com.cg.go.greatoutdoor.dto.wishlist.WishlistItemDetails;
import com.cg.go.greatoutdoor.entity.WishlistItemEntity;
import com.cg.go.greatoutdoor.service.IWishlistService;
import com.cg.go.greatoutdoor.util.WishlistUtil;

@RequestMapping("/Wishlist")
@RestController
public class WishlistItemController {
	@Autowired
	public IWishlistService wishlistService;
	@Autowired
	private WishlistUtil wishlistutil;
	/**
     * effective URL will be http://localhost:8585/Wishlist/add
	 * @throws WishlistException 
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    public WishlistItemDetails add(@RequestBody CreateWishlistItemRequest requestData) {
    	WishlistItemEntity additem =wishlistService.addWishlistItem(new WishlistItemEntity(requestData.getUserId()));
         return wishlistutil.toDetails(additem);
    }

    @GetMapping("/get/user/{id}")
	public List<WishlistItemDetails> fetchWishlist(@PathVariable("id") int userId) 
	{
    	List<WishlistItemEntity> add = wishlistService.findByUserId(userId);
		return wishlistutil.toDetails(add);
		
	}
	@GetMapping("/viewallItems")
	public List<WishlistItemEntity> findAllItems(){
		return wishlistService.findAll();
	}

 
    
    @DeleteMapping("/remove/{id}")
    public String deleteWishlist(@PathVariable("id") int userId) {
        wishlistService.deleteByUserId(userId);
        String response = "removed product with id=" + userId;
        return response;
    }
    
    
	
    

  

}
