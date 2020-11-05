package com.cg.go.greatoutdoor.cartItem.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.go.greatoutdoor.cartItem.dto.CartItemDetails;
import com.cg.go.greatoutdoor.cartItem.dto.CreateCartItemRequest;
import com.cg.go.greatoutdoor.cartItem.dto.UpdateCartItemRequest;
import com.cg.go.greatoutdoor.cartItem.entity.CartItemEntity;
import com.cg.go.greatoutdoor.cartItem.service.ICartService;

@RequestMapping("/cartitem")
@RestController
public class CartItemControlller {
	
	 private static final Logger Log = LoggerFactory.getLogger(CartItemControlller.class);
		
	@Autowired
	public ICartService cartService;
	
	/**
     * effective url will be http://localhost:8585/cartitem/add
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    public CartItemDetails add(@RequestBody CreateCartItemRequest requestData) {
        CartItemEntity cartItem = new CartItemEntity(requestData.getUserId(), requestData.getProducts(),
        		requestData.getCartTotalPrice(),requestData.getTotalQuantity());
        cartItem = cartService.addCart(cartItem);
        CartItemDetails details = toDetails(cartItem);
        return details;
    }

	@PutMapping("/update")
    public CartItemDetails update(@RequestBody UpdateCartItemRequest requestData) {
		CartItemEntity cartItem = new CartItemEntity(requestData.getUserId(), requestData.getProducts(),
        		requestData.getCartTotalPrice(),requestData.getTotalQuantity());
        cartItem = cartService.updateCart(cartItem);
        CartItemDetails details = toDetails(cartItem);
        return details;
    }


    

	@GetMapping("/by/userid/{id}")
    public List<CartItemDetails> findProduct(@PathVariable("id") Integer userId) {
    	List<CartItemEntity> cartItem = cartService.findCartlist(userId);
        List<CartItemDetails> details = toDetails(cartItem);
        return details;
    }
    
	@DeleteMapping("/remove/userid/{id}")
    public String deleteProduct(@PathVariable("id") Integer userId) {
        cartService.deleteCartlist(userId);
        String response = "removed products with userid=" + userId;
        return response;
    }
	
	private CartItemDetails toDetails(CartItemEntity cartItem) {
		// TODO Auto-generated method stub
		return null;
	}
	
    private List<CartItemDetails> toDetails(List<CartItemEntity> cartItem) {
		// TODO Auto-generated method stub
		return null;
	}
       
}