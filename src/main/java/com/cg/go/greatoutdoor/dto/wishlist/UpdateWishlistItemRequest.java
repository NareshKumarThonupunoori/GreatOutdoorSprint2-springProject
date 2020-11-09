package com.cg.go.greatoutdoor.dto.wishlist;

public class UpdateWishlistItemRequest {
//	@NotBlank @Size(min =2, max = 20)
	private int wishlistId;
	//@NotBlank @Size(min =2, max = 20)
    private int userId;
    //@ElementCollection
    //@NotBlank @Size(min =2, max = 20)
   // private List<String> productId;
	public long getWishlistId() {
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