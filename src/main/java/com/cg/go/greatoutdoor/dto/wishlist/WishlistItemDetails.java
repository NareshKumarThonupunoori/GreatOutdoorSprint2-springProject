package com.cg.go.greatoutdoor.dto.wishlist;


public class WishlistItemDetails {
	private int wishlistId;
    private int userId;
   // @ElementCollection
   // private List<String> productId;
    public WishlistItemDetails() {}
	public WishlistItemDetails(int wishlistId, int userId) {
		
		this.wishlistId = wishlistId;
		this.userId = userId;
		//this.productId = productId;
	}
	public int getWishlistId() {
		return wishlistId;
	}
	public void setWishlistId(int wishlistId) {
		this.wishlistId = wishlistId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/*public List<String> getProductId() {
		return productId;
	}
	public void setProductId(List<String> productId) {
		this.productId = productId;
	}*/
}
